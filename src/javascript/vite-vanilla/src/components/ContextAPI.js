/* eslint-disable no-unused-vars */
/* eslint-disable react/prop-types */
import React, { useState, createContext, useContext } from 'react';

const languages = ['JavaScript', 'Python'];

/** Context */
const LangContext = createContext({
 favProgrammingLang: 0,
 setFavProgrammingLang: () => {},
});

const LangProvider = ({ children }) => {
 const[favProgrammingLang, setFavProgrammingLang] = useState(languages[0]);

 return (
   <LangContext.Provider value={{ favProgrammingLang, setFavProgrammingLang }}>
     {children}
   </LangContext.Provider>
 );
};

/**
1. You must use the Context API for this challenge.

2. When you click the toggle button, 
the favorite programming language toggles between the items in the languages array. 

2. The default value should be the first item in the array.
*/
export function ContextAPI() {
  // implement Context here so can be used in child components
  return (
    <LangProvider>
      <MainSection />
    </LangProvider>
  );
}

function MainSection() {
  const { favProgrammingLang, setFavProgrammingLang } = useContext(LangContext);

  /**
    Toggle the language
  */
  const handleSetFavProgrammingLang = () => {
    if (favProgrammingLang === languages[0]) {
      setFavProgrammingLang(languages[1]);
    } else {
      setFavProgrammingLang(languages[0]);
    }
  }

  return (
    <div>
      <p id="favoriteLanguage">favorite programming language: {favProgrammingLang}</p>
      <button id="changeFavorite" onClick={handleSetFavProgrammingLang}>toggle language</button>
    </div>
  )
}
