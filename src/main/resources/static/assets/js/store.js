const { createApp } = Vue

createApp({
    data(){
        return {
            productUrl: "/api/products",
            genresUrl: "/api/genres",
            products: [],
            productsBackup: [],
            productsFilter: [],
            productsPrice: "",
            genres: [],
            filterMay: [],
            filterMen: [],
            filterPrices:[],
            inputGenres: "Select",
            filterGenres:[],
            searchProduct: "",
            gamesCart: []
        }
    },
    created(){
        this.loadData(),
        this.loadDataGenres()
    },
    methods:{
        loadData(){
            axios.get(this.productUrl)
            .then((respuesta) => {
                this.productsBackup = respuesta.data
                this.products = respuesta.data
                this.productsFilter = [...this.products]
            })
            .catch( exception => console.log(exception) ) 
        },
        loadDataGenres(){
            axios.get(this.genresUrl)
            .then((respuesta) =>{
                this.genres = respuesta.data
            })
            .catch( exception => console.log(exception)) 
        },
        filterPriceMen(){
            this.productsFilter = this.products.sort(function(a, b){return a.price - b.price})
        },
        filterPriceMay(){
            this.productsFilter = this.products.sort(function(a, b){return b.price - a.price})
        },
        modalDescription(game) {
            const genreDTO = game.genreDTOS
            let genreNameObject
            genreDTO.forEach(game => {
                genreNameObject = game.genre
            })
            Swal.fire({
                background: `${game.background}`,
                customClass: {
                    confirmButton: 'swalBtnColor',
                    popup: 'my-swal'
                },
                html: `
                    <div class="div-card">
                        <div>
                            <h2 class="text-light fw-bold text-center mb-0">${game.gameName}</h2>
                            <div class="d-flex justify-content-center">
                                <video class="rounded mt-3 video-card" src="${game.trailers}" width="800" autoplay height="600"></video>
                            </div>
                        </div>
                        <div class="d-flex mx-auto flex-column align-items-center justify-content-center">
                        <p class="text-light mt-4">${game.desc}</p>
                        <div class="d-flex px-2 gap-1 flex-wrap">
                            <div class="text-light">
                                ${game.minimumReq}
                            </div>
    
                            <div class="text-light">
                                ${game.recommendedReq}
                            </div>
                        </div>
                        <div>
                            <p class="mt-4 text-light fw-bold">Genre: ${genreNameObject.genreName}</p>
                        </div>
                        </div>
                    </div>
                    `,
                showClass: {
                    popup: 'animate__animated animate__fadeInDown'
                },
                hideClass: {
                    popup: 'animate__animated animate__fadeOutUp'
                }
            })
        },
        addGameCart(game) {
            Swal.fire({
                icon: 'success',
                background: `${game.background}`,
                customClass: {
                    confirmButton: 'swalBtnColor',
                    popup: 'my-swal'
                },
                html: `
                    <div>
                        <div>
                            <h2 class="text-light fw-bold text-center mb-0">${game.gameName} added to cart</h2>
                        </div>
                    </div>
                    `,
                showClass: {
                    popup: 'animate__animated animate__fadeInDown'
                },
                hideClass: {
                    popup: 'animate__animated animate__fadeOutUp'
                }
            })
            if(localStorage.length != 0) {
                this.gamesCart = JSON.parse(localStorage.getItem("game"))
                let gameFilter = this.gamesCart.filter(prop => prop.id == game.id)
                if(gameFilter.length > 0) {
                    Swal.fire({
                        icon: 'error',
                        background: `${game.background}`,
                        customClass: {
                            confirmButton: 'swalBtnColor',
                            popup: 'my-swal'
                        },
                        html: `
                            <div>
                                <div>
                                    <h2 class="text-light fw-bold text-center mb-0">${game.gameName} is already in the cart</h2>
                                </div>
                            </div>
                            `,
                        showClass: {
                            popup: 'animate__animated animate__fadeInDown'
                        },
                        hideClass: {
                            popup: 'animate__animated animate__fadeOutUp'
                        }
                    })
                } else {
                    this.gamesCart.push(game)
                    localStorage.setItem("game", JSON.stringify(this.gamesCart))
                }
            } else {
                this.gamesCart.push(game)
                localStorage.setItem("game", JSON.stringify(this.gamesCart))
            }
        },
        formatMoney(amount){
            let aux = amount
            let USDollar = new Intl.NumberFormat('en-US', {
                style: 'currency',
                currency: 'USD',
            });
            return USDollar.format(aux)
        }
    },
    computed:{
        filterGenresinput(){ 
            if(this.inputGenres == "" || this.inputGenres == "all") {
                this.productsFilter = this.products
            } else {
                let newArray = []
                this.products.forEach(product => {
                    product.genreDTOS.forEach(gen => {
                        if(gen.genre.genreName == this.inputGenres){
                            newArray.push(product)
                        }
                    })
                })
                this.productsFilter = newArray
            }
        },
        filterSearch() {
            if(this.searchProduct == "") {
                this.productsFilter = this.products
            } else {
                this.productsFilter = this.productsFilter.filter(product => product.gameName.toLowerCase().trim().includes(this.searchProduct.toLowerCase().trim()))
            }
        }
    }
}).mount('#content')   