# Table View with Drag and Drop Columns

For this problem space, we're dealing with multiple data structure considerations:

## Primary Data Structure

A Modified Hash Map would be ideal as the core structure where:

- Keys are the column/tag names
- Values are arrays of items (stocks)
- This provides O(1) lookup when moving items between columns

## Supports both views efficiently

Supporting Data Structures

- Array for Table View:
- Maintains order for the table representation
- Allows for easy sorting and filtering
- Each item contains its tag/column as a property

## Bi-directional Mapping

Keep a secondary index mapping:

```js
{
    itemId -> columnId  // Quick lookup of an item's column
    columnId -> [itemIds] // Quick lookup of a column's items
}
```

This supports O(1) operations for:

- Finding an item's current column
- Moving items between columns
- Updating tags

## State Management

```js
interface BoardState {
  columns: Map<string, {
    id: string;
    title: string;
    items: Set<ItemId>;  // Using Set for O(1) membership checks
  }>;
  items: Map<ItemId, ItemData>;
  itemToColumn: Map<ItemId, string>;  // Quick column lookup
}
```

This structure would provide:

- O(1) lookup for item locations
- O(1) drag and drop operations
- Efficient synchronization between views
- Easy tag updates
- Consistent state between both views

The trade-off is additional memory usage for the sake of operation speed, which is appropriate given the UI-focused nature of the application.
