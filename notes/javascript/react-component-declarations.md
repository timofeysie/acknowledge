# React Functional Component Declaration Patterns

## TL;DR

```typescript
const Component = (props: Props) => {
  const { name, age } = props;
  return <div>{name} is {age} years old</div>;
};
```

**VS Code Snippet**: `rce` (React Class Export) or `rafce` (React Arrow Function Component Export)

## Seven Ways to Declare a React Functional Component

Here are the different ways to declare a React functional component.

1. React.FC (Function Component)
2. Function Declaration
3. Function Expression
4. Arrow Function with Explicit Return Type
5. Inline Type Definition
6. React.VoidFunctionComponent
7. Props Parameter Pattern (my favorite)

## 1. React.FC (Function Component)

```typescript
interface Props {
  name: string;
  age?: number;
}

const Component: React.FC<Props> = ({ name, age }) => {
  return <div>{name} is {age} years old</div>;
};
```

## 2. Function Declaration

```typescript
function Component({ name, age }: Props) {
  return <div>{name} is {age} years old</div>;
}
```

## 3. Function Expression

```typescript
const Component = function({ name, age }: Props) {
  return <div>{name} is {age} years old</div>;
};
```

## 4. Arrow Function with Explicit Return Type

```typescript
const Component = ({ name, age }: Props): JSX.Element => {
  return <div>{name} is {age} years old</div>;
};
```

## 5. Inline Type Definition

```typescript
const Component = ({ name, age }: { name: string; age?: number }) => {
  return <div>{name} is {age} years old</div>;
};
```

## 6. React.VoidFunctionComponent

```typescript
const Component: React.VoidFunctionComponent<Props> = ({ name, age }) => {
  return <div>{name} is {age} years old</div>;
};
```

## 7. Props Parameter Pattern

This one is my favorite.
It is similar to the Function Declaration Pattern but uses a fat arrow instead of the `function` keyword.

```typescript
const Component = (props: Props) => {
  const { name, age } = props;
  return <div>{name} is {age} years old</div>;
};
```

**VS Code Snippet**: `rce` (React Class Export) or `rafce` (React Arrow Function Component Export)

## Pros and Cons

### React.FC

Pros:

- Includes children prop by default
- Provides better type checking for defaultProps
- Clear indication that it's a React component

Cons:

- Forces children prop even when not needed
- More verbose
- Some consider it unnecessary abstraction

```typescript
const Container: React.FC<{ title: string }> = ({ title, children }) => {
  return (
    <div>
      <h1>{title}</h1>
      {children}
    </div>
  );
};
```

### Function Declaration

Pros:

- Clean and simple
- More flexible
- No implicit children prop

Cons:

- Doesn't immediately signal it's a React component
- Requires explicit children typing if needed

```typescript
// Function declaration with children
function Container({ 
  title, 
  children 
}: { 
  title: string;
  children: React.ReactNode;
}) {
  return (
    <div>
      <h1>{title}</h1>
      {children}
    </div>
  );
}
```

### Arrow Functions

Pros:

- Modern syntax
- Consistent with other component patterns
- Good for higher-order components

Cons:

- Might be less readable for complex components
- Hoisting differences from function declarations

```typescript
// Arrow function with HOC
const withLogger = <P extends object>(
  WrappedComponent: React.ComponentType<P>
) => {
  return (props: P) => {
    console.log('Props:', props);
    return <WrappedComponent {...props} />;
  };
};
```

## Generic Components

### 1. Using React.FC

```typescript
interface Props<T> {
  items: T[];
  renderItem: (item: T) => React.ReactNode;
}

const List: <T>(props: Props<T>) => React.ReactElement = ({ items, renderItem }) => {
  return <div>{items.map(renderItem)}</div>;
};
```

### 2. Using Function Declaration

```typescript
function List<T>({ items, renderItem }: Props<T>) {
  return <div>{items.map(renderItem)}</div>;
}
```

## With Default Props

### Using React.FC

```typescript
interface Props {
  name: string;
  greeting?: string;
}

const Greeter: React.FC<Props> = ({ name, greeting = "Hello" }) => {
  return <div>{greeting}, {name}!</div>;
};
```

### Using Function Declaration

```typescript
function Greeter({ name, greeting = "Hello" }: Props) {
  return <div>{greeting}, {name}!</div>;
}
```

## Modern Approach (2024)

The current trend favors simpler function declarations:

```typescript
interface Props {
  name: string;
  age?: number;
}

function Component({ name, age }: Props) {
  return <div>{name} is {age} years old</div>;
}
```

## Type Utilities

```typescript
type PropsWithClassName<P = {}> = P & { className?: string };

function StyledComponent({ className, ...props }: PropsWithClassName<Props>) {
  return <div className={className} {...props} />;
}

interface Props {
  value: string;
}

const InputComponent = React.forwardRef<HTMLInputElement, Props>(
  (props, ref) => {
    return <input ref={ref} value={props.value} />;
  }
);
```

## When to Use Each Pattern

### Props Parameter Pattern

- When you have many props
- When you need to pass props through to children
- When you want to avoid destructuring complexity
- When working with TypeScript and want good type inference

### Destructured Props Pattern

- When you have few props
- When you want clean, readable code
- When you need default values
- When you want to clearly indicate required props

### React.FC Pattern

- When you need children prop
- When you want strong TypeScript integration
- When you want to clearly indicate it's a React component
- When working with defaultProps

### Function Declaration Pattern

- When you want simple, clean code
- When you need hoisting
- When you want flexibility
- When you don't need TypeScript

### Arrow Function with Explicit Return Type

- When you need explicit return type
- When working with HOCs
- When you want strong TypeScript integration
- When you need to indicate component behavior

### Inline Type Definition

- When you have a one-off component
- When you want to keep types close to component
- When you have simple prop types
- When you don't need reusable types

### VoidFunctionComponent

- When your component doesn't return children
- When you want to be explicit about component behavior
- When you need strong TypeScript integration
- When you want to indicate component purpose