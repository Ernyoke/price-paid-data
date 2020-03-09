# price-paid-data

## Get all content
```json
curl -XGET localhost:8080/all
```

## Get by id
```json
curl -XGET localhost:8080/id/%7B9DBAD221-E1D3-6EB3-E053-6B04A8C0F257%7D
```
Note: the ID can contain some special characters, those have to be encoded.

## Get by period
```json
curl -XGET localhost:8080/between/2002-05-30/2003-10-12
```
