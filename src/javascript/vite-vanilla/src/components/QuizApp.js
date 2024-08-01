/* eslint-disable react/no-unknown-property */
/* eslint-disable no-unused-vars */
import React, { useState } from 'react';
import { createRoot } from 'react-dom/client';

const style = {
  container: {
    padding: '20px',
    border: '1px solid #E0E0E0',
    borderRadius: '15px',
    width: 'max-content',
    marginBottom: '40px',
  },
  question: {
    fontWeight: 'bold',
    marginBottom: '10px',
  },
  options: {
    marginBottom: '5px',
  },
  button: {
    marginTop: '10px',
    padding: '10px 15px',
    border: 'none',
    backgroundColor: '#007BFF',
    color: '#FFF',
    fontSize: '14px',
    borderRadius: '5px',
    cursor: 'pointer',
  },
  feedback: {
    marginTop: '10px',
    fontSize: '14px',
  },
};

/**
The quiz will show the first question from the list. 
 
Once the user chooses an option and clicks "Submit", display "Correct!" or "Incorrect!".
 
If there are more questions, the next question should be shown with the previous feedback text still on screen. 

Otherwise, the app should display the user's total score out of the number of questions: 
"Quiz Complete! You scored 2 out of 2!".

For each question, users should be presented with multiple-choice options where each answer has a corresponding radio input type to the left of it. They should be able to select one by clicking on a radio button. Make sure to also assign unique ID's to each radio input element in the format: input[index], e.g. option1, option2, etc. with the first element starting at index 1.
*/
export function QuizApp() {
  const [currentQuestion, setCurrentQuestion] = useState(0);
  const [correctAnswers, setCorrectAnswers] = useState(0);
  const [answer, setAnswer] = useState();
  const [gameOver, setGameOver] = useState(false);

  // do not modify the questions or answers below
  const questions = [
    {
      question: 'What is the capital of France?',
      options: ['London', 'Paris', 'Berlin', 'Madrid'],
      correct: 'Paris',
    },
    {
      question: 'What is the capital of Germany?',
      options: ['Berlin', 'Munich', 'Frankfurt', 'Hamburg'],
      correct: 'Berlin',
    },
  ];

  const handleSubmit = (event) => {
    if (questions[currentQuestion].correct === answer) {
      setCorrectAnswers(correctAnswers + 1);
      console.log('correct');
    } else {
      console.log('not correct');
    }
    setCurrentQuestion(currentQuestion + 1);
    setAnswer(null);
    if (currentQuestion + 1 === questions.length) {
      console.log('game over');
      setGameOver(true);
    }
  }

  const handleAnswerChange = (event) => {
    if (event.target.value) {
      setAnswer(event.target.value);
    }
  }

  return (
    <div style={style.container}>
    { !gameOver ?  
      <>
        <div id="question" style={style.question}>
        {questions.length > currentQuestion && questions[currentQuestion]?.question}
        </div>
        <div style={style.options}>
          { questions[currentQuestion]?.options.map((answer, index) => {
          return (
            <div key={index+answer}>
              <input type="radio" id={index+answer} name={answer} value={answer} onChange={handleAnswerChange}/>
              <label for={index+answer}>
                {answer}
              </label>
            </div>)
            })}
        </div>
        <button style={style.button} id="submitBtn" onClick={handleSubmit}>
          Submit
        </button>
        </>
        :
        <div id="feedback" style={style.feedback}>Quiz Complete! You scored {correctAnswers} out of {questions.length}!</div>
    }
    </div>
  );
}
