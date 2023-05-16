let currentToken = "";
let expiresIn = 0

let getList = new XMLHttpRequest();
let oauthToken = new XMLHttpRequest();

async function getLists() {
    await getList.open('GET', 'http://localhost:8081/api/v1/transaksi/list?page=1&size=12')
    getList.addEventListener('load', () => {
        // console.log(JSON.parse(getList.responseText))
        // console.log(`bearer : ${currentToken}`)
    })
    getList.setRequestHeader('Authorization', `bearer ${currentToken}`)
    getList.send()
}

async function getOauthJWTToken() {
    oauthToken.open('POST', 'http://localhost:8081/api/oauth/token')
    oauthToken.addEventListener('load', () => {
        // console.log(JSON.parse(oauthToken.responseText))
        // console.log(JSON.parse(oauthToken.responseText)['access_token']) // buat login
        // console.log(JSON.parse(oauthToken.responseText)['expires_in']) // buat cookies
        // console.log(JSON.parse(oauthToken.response)['token_type']) // bearer

        expiresIn = JSON.parse(oauthToken.responseText)['expires_in']
        document.cookie = `login=cookie; path=/; max-age=${expiresIn};`; // two weeks
        currentToken = JSON.parse(oauthToken.responseText)['access_token']
        // console.log(document.cookie)
        getLists()
    })

    oauthToken.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
    const oauthTokenData = "username=admin%40mail.com&password=password" +
        "&grant_type=password&client_id=my-client-web&client_secret=password"
// req1.send(); req2.send();
    try {
        oauthToken.send(oauthTokenData);
    } catch (e) {
        console.log('error : ' + e);
    }
}

getOauthJWTToken().catch(e => console.log(e))