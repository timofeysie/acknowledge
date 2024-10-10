/* eslint-disable no-unused-vars */
/* eslint-disable react/prop-types */
import { useState } from 'react';

const style = {
  letterContainer: {
    overflow: 'auto',
    marginBottom: '10px'
  },
  letter: {
    float: 'left',
    padding: '10px 10px',
    background: '#c9e4ed',
    borderRadius: '5px',
    marginRight: '5px',
    cursor: 'pointer',
  },
}

/**
1. displays a tile for every letter in the alphabet in uppercase format.
2. if a tile is clicked, that letter is appended to the current string that exists in the element with ID outputString.
3. if there are 3 consecutive letters that are the same, replace them with an underscore. 
For example, if A, B, C, F, F, F, G is clicked in that order,
the string that appears in outputString would be ABC_G.
4. if 6 of the same letter appears after, for example, clicking A six times followed by a B, 
then outputString would be __B.
*/
function Tile(props) {
  return (
    <button style={style.letter} onClick={() => props.letterChosen(props.letter)}>{ props.letter }</button>
  );
}

export function LetterTiles(props) {
  const letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split('');
  const [outputString, setOutputString] = useState('');

  const letterChosen = (arg) => {
    // check for 3 consecutive letters that are the same
    if (outputString.length > 1) {
      // get last two letters
      const lastLetter = outputString.charAt(outputString.length - 1);
      const secondLastLetter = outputString.charAt(outputString.length - 2);
      if (lastLetter === arg && secondLastLetter === arg) {
        const newBase = outputString.slice(0, outputString.length - 2);
        setOutputString(newBase + "_");
      } else {
        setOutputString(outputString + arg);
      }
    } else {
      setOutputString(outputString + arg);
    }
  }

  return (
    <section>
      <aside style={style.letterContainer} id="letterContainer">
        { letters.map((letter, index) => {
          return (
            <div key={index+letter}>
              <Tile letter={letter} letterChosen={letterChosen} />
            </div>);
        })
        }
      </aside>
      <div id="outputString">-{outputString}-</div>
    </section>
  );
}
