let currentToken = "";

let req1 = new XMLHttpRequest();
let req2 = new XMLHttpRequest();
let getList = new XMLHttpRequest();
let oauthToken = new XMLHttpRequest();

async function getLists() {
    await getList.open('GET', 'http://localhost:8081/api/v1/transaksi/list?page=0&size=2')
    getList.addEventListener('load', () => {
        console.log(getList.responseText)
        console.log(`bearer : ${currentToken}`)
    })
    getList.setRequestHeader('Authorization', `bearer ${currentToken}`)
    getList.send()
}

req1.open('GET', 'https://fakestoreapi.com/products')
req2.open('GET', 'https://fakestoreapi.com/products/1')
oauthToken.open('POST', 'http://localhost:8081/api/oauth/token')
oauthToken.addEventListener('load', () => {
    console.log(JSON.parse(oauthToken.responseText))
    console.log(JSON.parse(oauthToken.responseText)['access_token']) // buat login
    console.log(JSON.parse(oauthToken.responseText)['expires_in']) // buat cookies
    console.log(JSON.parse(oauthToken.response)['token_type']) // bearer

    currentToken = JSON.parse(oauthToken.responseText)['access_token']
    getLists()
})

oauthToken.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')


const oauthTokenData = "username=admin%40mail.com&password=password" +
    "&grant_type=password&client_id=my-client-web&client_secret=password"
req1.send(); req2.send();
try {
    oauthToken.send(oauthTokenData);
} finally {
    // getLists()
}
