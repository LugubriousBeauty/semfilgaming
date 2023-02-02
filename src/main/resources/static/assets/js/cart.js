const { createApp } = Vue

const app = createApp({
    data() {
        return {
            gamesStorage: [],
            genreGame: undefined,
            gamesBackup: [],
            objectPurchase: [],
            totalPayment: 0,
            cvvCard: undefined,
            amount: undefined,
            numberCard: ''
        }
    }, 
    created() {
        this.loadGames()
    },  
    methods: {
        loadGames() {
            if(localStorage.length != 0) {
                this.gamesStorage = JSON.parse(localStorage.getItem("game"))
                this.gamesStorage.map(prop => prop.stockGame = 1)
                this.objectPurchase = this.gamesStorage.map(prop => {
                    return {
                        productId: prop.id,
                        productQuantity: prop.stockGame
                    }
                })
            }
        },
        deleteGame(id) {
            Swal.fire({
                title: 'Are you sure that want to remove that game?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#0057b9',
                cancelButtonColor: '#9b0000',
                confirmButtonText: 'Yes, delete it!'
              }).then((result) => {
                if (result.isConfirmed) {
                    this.gamesStorage = this.gamesStorage.filter(prop => prop.id !== id)
                    localStorage.removeItem(this.gamesStorage)
                    localStorage.setItem("game", JSON.stringify(this.gamesStorage))
                  Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                  )
                }
              })
        },
        stockQuantity(operation, game) {
            if(operation == 1) {
                if(game.stock > game.stockGame) {
                    game.stockGame++
                }
            } else {
                if(!game.stockGame < 1) {
                    game.stockGame--
                }
            }
        },
        formatMoney(amount){
            let aux = amount
            let USDollar = new Intl.NumberFormat('en-US', {
                style: 'currency',
                currency: 'USD',
            });
            return USDollar.format(aux)
        },
        payment() {
            axios.post('/api/clients/current/cards', `number=${this.numberCard}&cvv=${this.cvvCard}&amount=${this.amount}
            `)
                .then(() => {
                    axios.post('/api/products', ``)
                })
        }
    },
    computed: {
        totalPay() {
            if(this.gamesStorage.length > 0) {
                this.totalPayment = this.gamesStorage.map(prop => prop.totalAmount = prop.price * prop.stockGame).reduce((acc, ite) => acc += ite)
            } else {
                this.totalPayment = 0
            }
        }
    }
})
app.mount("#app")



function openNav() {
    document.getElementById("mySidebar").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}
    
function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}