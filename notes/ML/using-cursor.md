# Using Cursor

Agent mode has these options:

- Auto - The default mode where the AI will try to automatically determine the best way to help.
- Ask - This mode lets you ask questions or get explanations about your code.
- Manual - This mode gives you more control over how the AI assistant.

## Basic uses

- Tab complete, Multi-Line Edits and Smart Rewrites
- Ctl-L to open the chat window (and other keyboard shortcuts)
- add files to the prompt context
- "fix in chat"
- Write functions, TDD? Explain code? Write documentation?
- AI agents with [MCP servers](https://docs.cursor.com/agents/mcp-servers) for advanced use

### The downside of working with AI

Not designed to support critical thinking.

As humans increasingly rely on generative AI in their work, they use less critical thinking, which can “result in the deterioration of cognitive faculties that ought to be preserved.

It does not address awareness, motivation, and ability barriers.

ML tools are confident in presenting incorrect information, misleading attributions to syndicated content, and inconsistent information retrieval practices.

The hard part isn't writing code from scratch anymore.

- It's properly testing that code for bugs
- breaking down large problems into smaller steps the AI can handle
- knitting together those steps into a complete solution

It takes some software development experience to do so effectively – which limits the utility of AI code help for novices.

In general, the skills for writing clean code with best practices are still important.

- Break problems down into smaller steps
- Use solid principles like the Singe Responsibility Patter
- Use git often when things are working

At first I used it sparingly for small focused tasks.
But as I got better at prompting and learning about limitations I was able to do more.
With AI you can not only save time, you can reach higher and learn while doing in ways that weren't available before.

Its also important to use your knowledge when things start to go the wrong direction.

There are lessons to learn about starting over when things aren't working.

For example, if a prompt fails to get the desired result, and you try another prompt with goes in a different direction, often the code that didn't work the first time is left behind, and serves to confuse the model.

## Cursor's AI templates and rules system

Rules are included at the start of the model context.

Cursor [Context Rules](https://docs.cursor.com/context/rules) support three types:

1. Project Rules (current approach)
2. User Rules (applies to all projects)
3. .cursorrules File (deprecated method)

### 1. Project Rules (Modern Approach)

- Located in .cursor/rules directory
- Uses MDC format (.mdc file extension means 'markdown cursor')
- Version-controlled and scoped to your codebase

#### Rule Structure

- Always: Always included in the model context
- Auto Attached: Included when files matching specific patterns are referenced
- Agent Requested: Available to AI based on relevance
- Manual: Only included when explicitly referenced using @ruleName

### 2. User Rules

- Set globally in Cursor Settings > Rules
- Apply to all projects
- Always included in your model context
- Use plain text format (no MDC support)

### 3. .cursorrules File (Legacy/Deprecated)

- Still supported but being phased out
- Located in project root directory
- Recommended to migrate to Project Rules format

To create a new Project Rule:

Use Command Palette (Cmd/Ctrl + Shift + P)
Select "New Cursor Rule"
This creates a new .mdc file in .cursor/rules
Example MDC rule structure:

```mdc
---
description: RPC Service boilerplate
globs: 
alwaysApply: false
---

- Use our internal RPC pattern when defining services
- Always use snake_case for service names.

@service-template.ts
```

### Best practices for rules

- Keep them concise (under 500 lines)
- Split large concepts into multiple rules
- Provide concrete examples
- Write clear, actionable instructions
- Avoid vague guidance
- Reuse rules for common patterns

### Generating rules

You can generate rules directly in a conversation using the /Generate Cursor Rules command.

This is very useful when you've had a conversation where many decisions were made about how the agent should behave.

## An example of a Directory Structure Rule

A Components Directory Pattern (src/components/) has the following characteristics:

- Uses PascalCase for component files (e.g., Sidebar.tsx, PageHeader.tsx)
- Components are organized by feature/type (e.g., layout/, common/)
- Each component is a standalone file
- Direct component implementations

A rule to enforce this could look like this:

```mdc
# Component Directory Structure and Naming Convention

## Pattern
All React components should follow these conventions:

### Directory Structure
- Location: `src/components/`
- Subdirectories: `common/`, `layout/`, `feature/`
- Example: `src/components/layout/Sidebar/`

### File Naming
- Use PascalCase for component files
- Include `.tsx` extension for TypeScript React components
- Example: `Sidebar.tsx`

### Component Declaration
- Component name should match file name
- Use React.FC type annotation
- Export as default

## Examples

✅ Correct:
```typescript
// src/components/layout/Sidebar/Sidebar.tsx
const Sidebar: React.FC<SidebarProps> = () => {
  return (...)
};

export default Sidebar;
```

❌ Incorrect:
```typescript
// src/data/components/sidebar.tsx
const sidebar = () => {
  return (...)
};

export default sidebar;
```

Or in JSON format:

```json
{
  "componentNaming": {
    "filePattern": "src/components/**/*.{tsx,ts}",
    "rules": {
      "fileName": {
        "pattern": "^[A-Z][a-zA-Z0-9]*\\.tsx?$",
        "description": "Component files must use PascalCase (e.g., ComponentName.tsx)"
      },
      "directoryStructure": {
        "pattern": "^src/components/(?:common|layout|feature)/[A-Z][a-zA-Z0-9]*/",
        "description": "Components should be organized in feature-based directories under src/components/"
      },
      "componentDeclaration": {
        "pattern": "^const [A-Z][a-zA-Z0-9]*: React\\.FC",
        "description": "Component declarations should match file name and use React.FC type"
      }
    },
    "examples": {
      "valid": [
        "src/components/common/Button.tsx",
        "src/components/layout/Sidebar.tsx",
        "src/components/feature/UserProfile.tsx"
      ],
      "invalid": [
        "src/data/components/button.tsx",
        "src/components/sidebar.tsx",
        "src/components/userProfile.tsx"
      ]
    }
  }
}
```

The key differences between JSON and MDC rules in Cursor are:

Purpose:

- JSON rules are used for automated linting and enforcement and must follow exact patterns
- MDC rules are used as guidelines and best practices for the development team and can include context, explanations, examples, and migration guides in a more flexible format

Usage:

- JSON rules can be automatically enforced by tools and CI/CD pipelines
- MDC rules are referenced by developers during development and code reviews, serving more as documentation and guidelines

The MDC format we created is better for the above file structure use case because:

- It explains the "why" behind the conventions
- Provides clear examples of correct and incorrect usage
- Includes migration guidance
- Is easily readable and maintainable by the team

## Example: No Unused or Non-Working Solutions

```mdc
# Rule: No Unused or Non-Working Solutions

## Purpose
To maintain a clean, maintainable, and production-ready codebase, all contributors must ensure that no unused, experimental, or non-working code is left in the repository.

## Requirements
- Remove any code, files, or components that are not used in the current application or are known to be non-functional.
- Do not leave commented-out blocks of code that are not part of an active feature or fix.
- All code committed to the main branch must be functional and relevant to the current project requirements.
- If a solution is experimental or in-progress, it must be clearly marked and isolated in a feature branch or with a clear TODO comment and issue reference.
- Regularly review and refactor the codebase to eliminate dead code, unused imports, and obsolete files.

## Enforcement
- Code reviews should check for and flag any unused or non-working code.
- Automated linting and static analysis tools should be configured to warn about unused variables, imports, and unreachable code.
- Pull requests that introduce or leave behind non-working or unused code should not be approved until cleaned up.

## Rationale
Unused and non-working code increases technical debt, confuses contributors, and can introduce bugs or regressions. Keeping the codebase clean ensures better maintainability, readability, and reliability for all team members. 
```

## Other options

The field of integrating ML tools with editors will see a lot of churn.

Santiago likes Zed.

Zed is a rust editor that opens in under 1gb ram while 3 vscode open 1.7gb ram

As soon as u enable extensions in vscode is bye bye ram.

## General best practices when using AI

As well as creating rules for all prompts, create a Product requirements document, a features list, the tech stack being used and coding standards to follow.

### Create a Product requirements document

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

### Coding standards

- Use standard Prettier and ESLint rules.
- File/folder structure conventions
- Naming conventions
- Architecture principles
