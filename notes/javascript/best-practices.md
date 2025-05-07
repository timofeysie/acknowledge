# Coding Best Practices

Clean code is essential for maintaining and evolving software.

However, what clean code looks like is harder to define.

This document started out as a meta study of best practices.

It quickly grew to a gigantic list of individual opinions.  I will strive to categorize them and sift these ideas here into a more manageable discussions that I can use to inform  the way I approach code reviews and team management in general.

Types of conventions.

1. Workflow (Definition of done, branching strategies, etc)
2. Language specific best practices
3. Code organization
4. Code reviews
5. Documentation
6. Testing
7. Performance
8. Security

For example, SaaS application for public consumption have compliance concerns around HIPAA, SOC 2 or other regulations. This is combined with concerns about data and security should guide developers.

The best practices followed are influenced not only by the size of the application, but also by the size of the organization.

## Style Guides

Code Style includes formatting and linting.

Use Prettier standard formatting for the code base with as few exceptions as possible, such as a team might prefer "prettier.tabWidth": 4.

This is a frontend focused guide, and React specifically.  Since React has no official style guide, the [AirBnb guide](https://github.com/airbnb/javascript) can be used as a reference though it might be a bit outdated these days.

TypeScript also comes with its own specific style guide such as this one from the [TypeScript Deep Dive](https://basarat.gitbook.io/typescript/styleguide)

## Best practices meta study

This is all going to be sifted and edited.  For now here are some notes from the past few years I have been meaning to go over and coalesce into a more useful document.

In the [7 Best Practices for Software Developers](https://dev.to/devland/7-best-practices-for-software-developers-1l28) by Thomas Sentre posted on Feb 25, 2023 article, as well as basic concerns such as choosing proper technologies and tools the author lists:

Developers should also be concerned with:

3. Minimizing the amount of coding
4. Coding conventions
5. Testing
6. Code reviews
7. Documentation

Note I am not including all the advice.  These are just the pertinent items and I may have considered the others "no-brainers" and not needed for my study.

Another article on Dev.to by dcodes posted on May 18, 2023 [Write better code by following these JavaScript best practices](https://dev.to/dawsoncodes/write-better-code-by-following-these-javascript-best-practices-25mp) has a long list of best practices.

1. Adopt a Consistent Coding Style
2. Naming variables and functions
3. Use Shorthands but Be Cautious
4. Add meaningful comments to your code
5. Follow the SoC principle
6. Avoid global variables
7. Use for...of Instead of for Loops
8. Adhere to the Single responsibility principle
9. Understand the Lack of Hoisting in Classes
10. Avoid Mutating Function Arguments
11. Handle Promises Correctly
12. Avoid the Over-Nesting in your code
13. Optimizing for loops

Yet another dev.to article by Sathish posted on Mar 11, 2023 [Part 4: Writing clean and efficient React code: best practices and optimization techniques](https://dev.to/sathishskdev/part-4-writing-clean-and-efficient-react-code-best-practices-and-optimization-techniques-423d) combines best practices with optimization.

1. Implement error boundaries to handle component errors gracefully
2. Use React.memo for functional components
3. Use Linting for Code Quality
4. Avoid default export
5. Use object destructuring
6. Use fragments
7. Prefer passing objects instead of multiple props
8. Use arrow function
9. Use enums instead of numbers or strings
10. Use shorthand for boolean props
11. Avoid using indexes as key props
12. Use implicit return in small functions
14. Prefer using template literals
15. Avoid huge component

Notice I removed #13. Use PropTypes for type checking.  Since I use TypeScript, my opinion is either you use Typescript or you go the vanilla route and just use simple JS.  The goal of this document is for complex code bases that grow large and still need to be maintainable and scalable.  So probably TypeScript could be considered a meta-best practice, or appropriate tool.

Sathish actually has a four part series on React best practices called [React Best Practices in 2023](https://dev.to/sathishskdev/series/22988).

- Part 1: Naming Conventions - The Foundation of Clean Code
- Part 2: Folder Structure - Building a Solid Foundation
- Part 3: Component Structure - Building Reusable and Maintainable Components in React!
- Part 4: Writing Clean and Efficient React Code- Best Practices and Optimization Techniques

I wont attempt to cover all of that right now.  #15 from [part three](https://dev.to/sathishskdev/part-3-component-structure-building-reusable-and-maintainable-components-in-react-54n6): Avoid huge component is super important.  In Angular 300 lines of code was considered the limit for a single file.

Here is another [TypeScript Best Practices](https://medium.com/@sobitdaniel/typescript-best-practices-610e8facb8df) article by Daniel Sobit.  I have left off some generic items like naming and defaults for now, but in general these are best practices for coding in general.

3. Functions should only perform one action.
4. Function names should say what they do
5. Favor functional programming over imperative programming  
6. Avoid negative conditionals
7. Use inheritance and polymorphism to make code more extensible and easier to maintain
8. Remove unused code
9. Use getters and setters to access data from objects.
10. Use SOLID Principles

Things like #8 should be included in a code review checklist.

[A Guide to Coding Standards to Improve Code Quality](https://dev.to/documatic/a-guide-to-coding-standards-to-improve-code-quality-68n) by Suraj Vishwakarma posted on Jun 16, 2023.

1. Naming Convention
2. Comments and Documentation
3. Error Handling
4. Testing Application
5. Security

Point 5 is worth listing the common security vulnerabilities mentioned.

- Input Validation
- Authentication and Authorization (strong password hashing, enforcing password complexity, and role-based access)
- Data protection (encryption, secure key management, and secure storage practices)

Another aspect of best practices is highlighted in [Stop Over-Engineering your Medium Size Front-End Application](https://fadamakis.com/stop-over-engineering-your-medium-size-front-end-application-b3f8313c464b) by Fotis Adamakis posted on Jun 16, 2023.

- Typescript: YES ✅
- State Management: YES ✅
- Feature Flags: YES ✅
- Testing: YES ✅ or NO ⛔️
- CI/CD: YES ✅
- Domain Driven Design: NO ⛔️
- Hexagonal Architecture: NO ⛔️
- Micro Frontends: NO ⛔️
- CDN: YES ✅
- Linting: YES ✅
- Observability: YES ✅
- Accessibility: YES ✅
- Design system: NO ⛔️

This opinionated list has me wondering why the nos.

Testing: Some testing might not be essential for a smaller codebase, such as:

- mutation tests
- load tests
- stress tests
- performance tests
- visual tests
- snapshot tests

I had to look up what Hexogonal Architecture is.  Defined as *Ports and Adapters*, it's an architectural pattern to create a clear separation between an application’s core business logic and its external dependencies, such as databases, APIs, and UIs.  Similar to DDD it's considered an overkill for a medium-sized application.

Testing: When it comes to medium-scale applications, it’s important to find the balance between writing enough tests to ensure stability and not over-engineering the testing process.

Design System: It says a design system *may be unnecessary for medium-sized applications. Instead focus on configuring an existing component library according to needs and establishing a set of guidelines and reusable components within your application to maintain consistency and improve developer efficiency.*

[Best Practices for Writing Clean React Code](https://fadamakis.com/stop-over-engineering-your-medium-size-front-end-application-b3f8313c464b) by Amrita-padhy posted on Oct 10, 2023

My notes pull out two items from the list of ten:

- Use PureComponent or Memoization: To improve performance, use React.memo or extend React.PureComponent for components that don't need to re-render on every prop change. This can prevent unnecessary rendering.

- Use stateless components: One should use stateless components whenever possible. Stateful components are more complex and harder to reason about. Stateless components are easier to reuse and compose since they only have to render based on the data passed to them through props. They are also easier to test since they don't have any internal state to manage.

Other articles I found useful:

[Best Practices for Writing Clean React Code](https://dev.to/amritapadhy/best-practices-for-writing-clean-react-code-59fm) by Amrita-padhy posted on Oct 10, 2023

[React Best Practices](https://bluesockets.com/react/reactjs-best-practices/) by Bluesockets posted on Jan 10, 2024 (defunct?)

[ReactJS Good Practices](https://dev.to/nikacodes/reactjs-good-practices-59b3) by Niko posted on Jan 10, 2024

[10 Github Repositories to Achieve JavaScript Mastery](https://dev.to/novu/10-github-repositories-to-achieve-javascript-mastery-50hk) by Novu posted on Jan 10, 2024

[Production Level Patterns for React Hooks](https://www.fullstacklabs.co/blog/production-level-patterns-for-react-hooks) by Fullstack Labs posted on Jan 10, 2024

[Writing Clean, Reusable Components in React (Best Practices)](https://dev.to/codewithshahan/writing-clean-reusable-components-in-react-best-practices-2gka) by Shahan posted on Jan 10, 2024

User generated best practices: [What are your best clean code tips?](https://dev.to/devteam/what-are-your-best-clean-code-tips-khm) by Dev.to posted on Jan 10, 2024

## Best practices when using AI

## Create a Product requirements document

This document outlines:

- What the application does
- Required technologies
- Design patterns
- Technical specifications

Given that this app was created with Bolt.new, its development style can follow the standard React File/folder structure and coding conventions that Bolt.new uses.

### Features

- User authentication (login/register)
- User profiles with customizable details
- Role-based access (admin/guest)
- Responsive design with mobile-first UI
- Secure backend with Supabase

### Tech Stack

- React
- TypeScript
- Tailwind CSS
- Supabase (Authentication & Database)
- Vite

### Cursor rules

The rules for Cursor to follow when working with your code:

#### Coding standards

- Use standard Prettier and ESLint rules.
- File/folder structure conventions
- Naming conventions
- Architecture principles
