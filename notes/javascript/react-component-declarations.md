# React Functional Component Declaration Patterns

Here are six different ways to declare a React functional component.

1. React.FC (Function Component)
2. Function Declaration
3. Function Expression
4. Arrow Function with Explicit Return Type
5. Inline Type Definition
6. React.VoidFunctionComponent
7. Props Parameter Pattern

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

```typescript
const Component = (props: Props) => {
  const { name, age } = props;
  return <div>{name} is {age} years old</div>;
};
```

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
