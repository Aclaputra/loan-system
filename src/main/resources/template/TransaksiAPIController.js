let getList = new XMLHttpRequest();

async function getLists() {
    await getList.open('GET', 'http://localhost:8081/api/v1/transaksi/list?page=1&size=12')
    getList.addEventListener('load', () => {
        // console.log(JSON.parse(getList.responseText))
        console.log(`bearer : ${currentToken}`)
    })
    getList.setRequestHeader('Authorization', `bearer ${currentToken}`)
    getList.send()
}

getOauthJWTToken().catch(e => console.log(e))