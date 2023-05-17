let oauthToken = new XMLHttpRequest();
let currentToken = "";
let expiresIn = 0

async function getOauthJWTToken() {
    try {
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

        oauthToken.send(oauthTokenData);
    } catch (e) {
        console.log('error : ' + e);
    }
}