import React from "react";
import logo from "./logo.svg";
import { Counter } from "./features/counter/Counter";
import "./App.css";
import { quickSort } from "./features/quicksort/quicksort";

function App() {
  const numbers = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5];
  const sortedNumbers = quickSort(numbers, {
    compareCallback: (a, b) => a - b,
    visitingCallback: (element) => console.log(`Visiting: ${element}`),
  });
  console.log('sorting number')
  console.log("before", numbers)
  console.log("after", sortedNumbers);

  // Example with custom comparator (sorting strings by length)
  const words = ["apple", "banana", "cherry", "date", "elderberry"];
  const sortedWords = quickSort(words, {
    compareCallback: (a, b) => a.length - b.length,
  });
  console.log("sorting words by length");
  console.log("before", words);
  console.log("after", sortedWords);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Counter />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <span>
          <span>Learn </span>
          <a
            className="App-link"
            href="https://reactjs.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            React
          </a>
          <span>, </span>
          <a
            className="App-link"
            href="https://redux.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            Redux
          </a>
          <span>, </span>
          <a
            className="App-link"
            href="https://redux-toolkit.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            Redux Toolkit
          </a>
          ,<span> and </span>
          <a
            className="App-link"
            href="https://react-redux.js.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            React Redux
          </a>
        </span>
      </header>
    </div>
  );
}

export default App;
