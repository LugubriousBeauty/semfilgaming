const { createApp } = Vue

const app = createApp({
    data() {
        return {
            games: [],
            gamesAleatory: [],
            fourGames: []
        }
    },
    created() {
        this.chargeGames()
    },
    methods: {
        chargeGames() {
            axios.get('/api/products')
                .then(response => {
                    this.games = response.data
                    this.gamesAleatory = this.games.sort(() => Math.random() - 0.5)
                    this.fourGames = this.gamesAleatory.splice(0, 4)
                })
                .catch(error => console.log(error))
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
                    <h2 class="text-light fw-bold text-center mb-0">${game.gameName}</h2>
                    <div class="d-flex justify-content-center">
                        <video class="rounded mt-1" src="${game.trailers}" width="800" autoplay height="600"></video>
                    </div>
                    <p class="text-light">${game.desc}</p>
                    <div class="d-flex px-2 gap-1 flex-wrap">
                        <div class="text-light">
                            ${game.minimumReq}
                        </div>

                        <div class="text-light">
                            ${game.recommendedReq}
                        </div>
                    </div>
                    <button class="btn-login mt-4">${genreNameObject.genreName}</button>
                    `,
                showClass: {
                    popup: 'animate__animated animate__fadeInDown'
                },
                hideClass: {
                    popup: 'animate__animated animate__fadeOutUp'
                }
            })
        },
        login() {
            location.href = '../../login.html'
        }
    }
})

app.mount("#content")





































function openNav() {
    document.getElementById("mySidebar").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}