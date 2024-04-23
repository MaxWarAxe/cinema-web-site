<template>
    <div class="film_container">
        <img class="film_img" src="@/assets/images/example.png" alt="">
        <div class="film_desc">
            <div class="age_restrict">18+</div>
            <div class="film_name">Крутой фильм 2</div>
            <div class="film_genres">Драмма, Боевик</div>
            <div class="film_duration">2 час 30 мин.</div>
        </div>
        <div class="film_shows">
            <div class="show_container">
                <div class="time_and_money">
                    <div class="time">10:20</div>
                    <div class="money">от 150Р</div>
                </div>
                <div class="hall_type">2D</div>
            </div>
        </div>
    </div>
</template>

<script setup>

</script>

<style scoped>
.film_container {
    width: 100%;
    height: 400px;
    display: flex;
    flex-wrap: wrap;
    margin-bottom: 50px;
}

.film_img {
    height: 100%;
    border-radius: 10px;
    margin-right: 20px;
}

.film_desc {
    width: 200px;
    height: 100%;
    color: rgb(136, 136, 136);
    margin-right: 20px;
}

.age_restrict {
    width: 35px;
    height: 25px;
    line-height: 25px;
    background-color: rgb(17, 17, 17);
    color: white;
    border: solid;
    border-radius: 5px;
    border-width: 1px;
    text-align: center;

    margin-bottom: 20px;
}

.film_name {
    color: white;
    font-weight: bold;
    font-size: 20px;
    margin-bottom: 20px;
}

.film_shows {
    width: 695px;
    height: 100%;
    display: flex;
    flex-wrap: wrap;
    color: rgb(136, 136, 136);
}

.show_container {
    width: 100px;
    height: 80px;
    display: block;
    text-align: center;
    margin-right: 15px;
}

.show_container:hover div {
    color: rgb(135, 135, 255);
    cursor: pointer;
    transition: 0.4s;
}

.time_and_money {
    color: white;
    border: solid;
    text-align: center;
    border-width: 2px;
    border-radius: 10px;
}

.money {
    color: rgb(136, 136, 136);
}

.film_sep_line {
    width: 100%;
    color: rgb(136, 136, 136);
    height: 2px;
    border-radius: 1px;
    background-color: rgb(136, 136, 136);
    margin-bottom: 50px;
}
</style>