async function getAllData() {
    const req = await fetch('https://fakestoreapi.com/products')
        .then((res) => {
            console.log(res.headers.get('Content-Type'))
            // console.log(res.headers.get('Date'))

            console.log(res.status)
            console.log(res.statusText)
            console.log(res.type)
            console.log(res.url)
            console.log(res.body)
            console.log(res.redirected)
            console.log(res.arrayBuffer())
        })
}
getAllData().catch(e => console.log(e))

document.cookie = 'school=raharja;'
// document.cookie = `snack=chips; path=/; max-age=${60 * 60 * 24 * 14};`; // two weeks
// document.cookie = `sementara=isisementara; path=/; max-age=${10}` // 10 detik
window.localStorage.setItem("my key", "chime chibuike princewill" )
console.log("local storage " + localStorage.getItem('my key'))