# Request Parameters

## POST　/author

|    | 名称      | 内容                  |
|----|----------|-----------------------|
| 必須 | `name`   | 著者名                 |
|    | `url`    | 著者プロフィールページURL |

### 例

```
{
  "name": "Rieko Nakagawa",
  "url": "https://rieko.com"
}
```

## PUT　/author

|        | 名称     | 内容             |
|--------|--------|----------------|
| 必須    | `id`   | 著者ID           |
| 必須    | `name` | 著者名            |
|     | `url`  | 著者プロフィールページURL |

### 例

```
{
  "id": "1",
  "name": "Rieko Nakagawa",
  "url": "https://rieko.com"
}
```
## POST　/book

|    | 名称         | 内容     |
|----|------------|--------|
| 必須 | `title`    | 書籍タイトル |
| 必須 | `authorId` | 著者ID   |

### 例

```
{
  "title": "Guri and Gura",
  "authorId": "1"
}
```

## PUT　/book

|    | 名称         | 内容     |
|----|------------|--------|
| 必須 | `id`       | 書籍ID   |
| 必須 | `title`    | 書籍タイトル |
| 必須 | `authorId` | 著者ID   |

### 例

```
{
  "id": "1",
  "title": "Guri and Gura",
  "authorId": "1"
}
```
