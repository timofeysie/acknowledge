# OpenAI API

## OpenAI API models

Here we will use OpenAI API for

o Text Generation using the new "gpt-4.1-2025-04-14" model 
o Image Generation using “DALL·E 3” model

The [official documentation for reponses](https://platform.openai.com/docs/api-reference/responses) states:

- Supports text and image inputs
- Text outputs
- Create stateful interactions with the model, using the output of previous responses as input
- Extend the model's capabilities with built-in tools for file search, web search, computer use, and more.
- Allow the model access to external systems and data using function calling.

You would need a [key](https://platform.openai.com/settings/organization/api-keys) to use this API.  The example call shown in the docs is:

```txt
curl https://api.openai.com/v1/models \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -H "OpenAI-Organization: YOUR_ORG_ID" \
  -H "OpenAI-Project: $PROJECT_ID"
```

### Create a model response

post: https://api.openai.com/v1/responses

```txt
curl https://api.openai.com/v1/responses \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -d '{
    "model": "gpt-4.1",
    "input": "Tell me a three sentence bedtime story about a unicorn."
  }'
```

Example response:

```json
{
  "id": "resp_67ccd2bed1ec8190b14f964abc0542670bb6a6b452d3795b",
  "object": "response",
  "created_at": 1741476542,
  "status": "completed",
  "error": null,
  "incomplete_details": null,
  "instructions": null,
  "max_output_tokens": null,
  "model": "gpt-4.1-2025-04-14",
  "output": [
    {
      "type": "message",
      "id": "msg_67ccd2bf17f0819081ff3bb2cf6508e60bb6a6b452d3795b",
      "status": "completed",
      "role": "assistant",
      "content": [
        {
          "type": "output_text",
          "text": "In a peaceful grove beneath a silver moon, a unicorn named Lumina discovered a hidden pool that reflected the stars. As she dipped her horn into the water, the pool began to shimmer, revealing a pathway to a magical realm of endless night skies. Filled with wonder, Lumina whispered a wish for all who dream to find their own hidden magic, and as she glanced back, her hoofprints sparkled like stardust.",
          "annotations": []
        }
      ]
    }
  ],
  "parallel_tool_calls": true,
  "previous_response_id": null,
  "reasoning": {
    "effort": null,
    "summary": null
  },
  "store": true,
  "temperature": 1.0,
  "text": {
    "format": {
      "type": "text"
    }
  },
  "tool_choice": "auto",
  "tools": [],
  "top_p": 1.0,
  "truncation": "disabled",
  "usage": {
    "input_tokens": 36,
    "input_tokens_details": {
      "cached_tokens": 0
    },
    "output_tokens": 87,
    "output_tokens_details": {
      "reasoning_tokens": 0
    },
    "total_tokens": 123
  },
  "user": null,
  "metadata": {}
}
```

### Models

Options are strings such as:

- gpt-4o
- o3
- gpt-4.1 (the flagship model)
- gpt-4.1-2025-04-14
- DALL·E 3 (the latest image generation model)

By all means checkout the [available models](https://platform.openai.com/docs/models).

There are a lot of options parameters such as:

- include: Specify additional output data to include in the model response. Currently supported values are:
- instructions: Inserts a system (or developer) message as the first item in the model's context.
- max_output_tokens: An upper bound for the number of tokens that can be generated for a response, including visible output tokens and reasoning tokens.
- metadata: Set of 16 key-value pairs that can be attached to an object. This can be useful for storing additional information about the object in a structured format, and querying for objects via API or the dashboard.
- parallel_tool_calls: Whether to allow the model to run tool calls in parallel.
- previous_response_id: The unique ID of the previous response to the model. Use this to create multi-turn conversations. Learn more about conversation state.
- reasoning: Configuration options for reasoning models.
- service_tier: Specifies the latency tier to use for processing the request. This parameter is relevant for customers subscribed to the scale tier service:
- store: Whether to store the generated model response for later retrieval via API.
- stream: If set to true, the model response data will be streamed to the client as it is generated using server-sent events. See the Streaming section below for more information.
- temperature: What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic. We generally recommend altering this or top_p but not both.
- text: Configuration options for a text response from the model. Can be plain text or structured JSON data. Learn more:
- tool_choice: How the model should select which tool (or tools) to use when generating a response. See the tools parameter to see how to specify which tools the model can call.
- tools: An array of tools the model may call while generating a response. You can specify which tool to use by setting the tool_choice parameter.
