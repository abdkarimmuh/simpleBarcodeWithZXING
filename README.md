# Generate Barcode
> Generate barcode with zxing

### Implementation
* [zxing](https://github.com/zxing/zxing)
* [retrofit](https://github.com/square/retrofit)
* [json-server](https://github.com/typicode/json-server)


## Installation WebService

1. Install json-server

```sh
npm install -g json-server
```

2. Change directory `webservice` in project

3. Run 

```sh
json-server --watch --host 192.168.XXX.XXY db.json
```

4. Edit `BASE_URL` in 'RetrofitClientInstance'

Check in [json-server](https://github.com/typicode/json-server)