# Using Cursor

Agent mode has these options:

- Auto - The default mode where the AI will try to automatically determine the best way to help.
- Ask - This mode lets you ask questions or get explanations about your code.
- Manual - This mode gives you more control over how the AI assistant.

The interface you're seeing might look different from cursor.com because:

- The website may be showing an older/different version
- Cursor's interface is frequently updated with improvements
- Some features may be gradually rolled out or may vary based on your installation

### Basic uses

- Sentence completion (watch out for it making stuff up!)
- Explaining code
- Writing docs
- Writing unit tests

- Tab complete
- Ctl-L
- "fix in chat"
- TDD?

### The downside of working with AI

Tab  complete
Multi-Line Edits
Smart Rewrites
Predictions

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

### Rule Structure

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

This is very useful when you’ve had a conversation where many decisions were made about how the agent should behave. Simply generate the rule and reuse it in the future.
