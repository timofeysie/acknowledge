# Styled Components

Here are some notes from the official [Styled Components](https://styled-components.com/docs/basics#getting-started) documentation.

## Adapting based on prop

```js
const Button = styled.button<{ $primary?: boolean; }>`
  /* Adapt the colors based on primary prop */
  background: ${props => props.$primary ? "#BF4F74" : "white"};
  color: ${props => props.$primary ? "white" : "#BF4F74"};
...
`;

render(
  <div>
    <Button>Normal</Button>
    <Button $primary>Primary</Button>
  </div>
);

```js

## Extending Styles

```js
// The Button from the last section without the interpolations
const Button = styled.button`
  color: #BF4F74;
  ...
`;

// A new component based on Button, but with some override styles
const TomatoButton = styled(Button)`
  color: tomato;
  border-color: tomato;
`;

render(
  <div>
    <Button>Normal Button</Button>
    <TomatoButton>Tomato Button</TomatoButton>
  </div>
);
```

to change which tag or component a styled component renders, use an escape hatch with the "as" polymorphic prop to dynamically swap out the element that receives the styles (works perfectly with custom components too):

```js
const ReversedButton = props => <Button {...props} children={props.children.split('').reverse()} />

render(
  <div>
    <Button>Normal Button</Button>
    <Button as="a" href="#">Link with Button styles</Button>
    <TomatoButton as="a" href="#">Link with Tomato Button styles</TomatoButton>
    <Button as={ReversedButton}>Custom Button with Normal Button styles</Button>
  </div>
);
```

Attach the passed className prop to a DOM element to work on any third-party component.

```js
const Link = ({ className, children }) => (
  <a className={className}>{children}</a>
);

const StyledLink = styled(Link)`
  color: #BF4F74;
  font-weight: bold;
`;

render(
  <div>
    <Link>Unstyled, boring Link</Link>
    <StyledLink>Styled, exciting Link</StyledLink>
  </div>
);
```

## Passed props

Here, all props of the Input component are passed on to the DOM node that is mounted, as with React elements.

```js
const Input = styled.input<{ $inputColor?: string; }>`
  color: ${props => props.$inputColor || "#BF4F74"};
`;

render(
  <div>
    <Input defaultValue="@probablyup" type="text" />
    <Input defaultValue="@geelen" type="text" $inputColor="rebeccapurple" />
  </div>
);
```

## Important

- define styled components outside of the render method
- use the same component name for both the styled component and the original component
- use the same props for both the styled component and the original component
- use the same default props for both the styled component and the original component
- use the same ref forwarding for both the styled component and the original component
- use the same displayName for both the styled component and the original component
