# Functional Design Patterns

Many object-oriented programming design patterns can be applicable to React apps using functional programming paradigms and hooks, but their application often changes to fit React's specific context.

## Applicable patterns

- Singleton
- Observer
- Factory
- Strategy
- Composite
- Decorator
- Command
- Adapter
- Facade
- Mediator
- Flyweight
- Chain of Responsibility

## Patterns not applicable

- Prototype
- Builder

## Applicable patterns in React

### Singleton

This pattern ensures that a class has only one instance. In React, you might use this pattern to manage global application state with something like the Context API, where a single context provider manages state for its consumers.

### Observer

React's state and props system, combined with hooks like useEffect, naturally align with observer patterns. Components react to state changes without explicitly managing dependencies.

### Factory

While hooks reduce the use of class-based components, this pattern could still apply to modular, reusable component generation. Factory-like functions or higher-order components (HOCs) are examples of how React handles abstraction and reusability.

This applies when using functions to create reusable components, hooks, or configurations, especially when generating dynamic forms or UI elements.

### Strategy

This pattern works well with functional components. You can implement it by passing functions or components as props, allowing you to dynamically swap behavior or visual rendering.

React props can be used to dynamically inject behavior or rendering logic into components, which fits well with this pattern.

### Composite

React's component tree is essentially a composite structure. Functional components fit into a hierarchy, much like the composite pattern allows individual objects to be treated uniformly as part of a whole.

React's component tree structure is an excellent example of the composite pattern, allowing components to be treated uniformly whether they're simple or composed of other components.

### Decorator

HOCs and custom hooks (like a useAuth or useLogger hook) are functional equivalents of the decorator pattern. They extend functionality without modifying the core component.

Higher-order components (HOCs) and custom hooks function as decorators, augmenting components or logic without modifying the core.

### Command

Though more common in OOP, you can implement it functionally by passing handler functions (commands) through props, triggering specific actions.

However, some patterns, like the Prototype or Builder, may not directly map to React's paradigms, as they are more class-oriented and deal with object instantiation in ways that aren't typical in React.

Ultimately, adapting these patterns often involves leveraging React's core principles, such as declarative UI, functional components, hooks, and composition.

## Patterns that are somewhat applicable

Abstract Factory: While traditionally used to create families of related objects, in React you could interpret this as a function or a set of functions that generate related components or reusable hooks. For instance, a factory might provide multiple useForm hooks for various input types.

Flyweight: This pattern focuses on minimizing memory usage by sharing data between objects. In React, this aligns with memoization strategies, like React.memo or useMemo, to prevent unnecessary re-renders or duplicate computation.

React's memoization tools (React.memo, useMemo, etc.) implement the essence of this pattern by sharing resources to reduce memory usage.

Memento: This pattern captures and restores an object's state. You can achieve this in React by storing state snapshots using useState or useReducer. Libraries like Redux also help implement this concept for managing undo/redo functionality.

Adapter: Adapters bridge the gap between incompatible interfaces. In React, you might use this when converting API responses or legacy data structures into formats that your components or hooks can easily consume.

Commonly used to transform data or APIs into a structure consumable by React components or hooks.

Proxy: This pattern adds an intermediary to control access to an object. In React, a proxy-like behavior could be implemented using HOCs or hooks to wrap components, adding logic like authentication or caching without modifying the component itself.

Iterator: While React doesn’t inherently follow the iterator pattern, tools like map() or custom hooks (useIterator) allow you to traverse and manage collections of data or components in a similar manner.

Bridge: This pattern decouples abstraction from implementation. React inherently follows this idea with props, allowing components to receive behavior (functions) and data separately. Custom hooks can also act as bridges by encapsulating complex logic.

Facade: A facade simplifies complex subsystems. In React, you can encapsulate intricate state management or UI libraries within custom hooks or utility functions, exposing a simpler API to your components.

Facade: You can simplify complex state management or APIs into a single custom hook or utility that hides the complexity from the components consuming it.

Chain of Responsibility: This pattern allows a request to pass through a chain of handlers until one can process it. In React, you might use this concept for event handling or middleware-like patterns, often seen in Redux with enhancers or middlewares.

Chain of Responsibility: Middleware-like flows in Redux or event handlers in React are examples where this pattern applies, as requests pass through handlers until one processes them.

Mediator: Mediators facilitate interaction between objects without them knowing about each other directly. In React, the Context API serves as a mediator by enabling components to communicate through shared context values without direct coupling.

Mediator: The Context API acts as a mediator, enabling communication between components without direct dependencies.


Visitor: While less common in functional paradigms, you could implement a visitor-like pattern to traverse or transform React components, such as recursively rendering nested structures like forms or trees.

others, like Singleton or Proxy, may require more specific use cases to fully translate.

Not every pattern perfectly translates to React, especially given its emphasis on declarative UI, composition, and hooks. However, many can inspire creative solutions to common problems. Are you considering one of these patterns for a specific use case? Let's dive deeper!

