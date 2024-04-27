<template>
    <header>
        <div class="header_container">
            <img class="logo" src="@/assets/images/logo.png" alt="logo">
            <ul class="w-full">
                <li><a class="underline_effect">
                        <RouterLink to="/films">Расписание</RouterLink>
                    </a></li>
                <li><a class="underline_effect">
                        <RouterLink to="/contacts">Контакты</RouterLink>
                    </a></li>
                
                <li class="float-right"><a class="underline_effect">
                    <RouterLink to="/login">Вход</RouterLink>
                </a></li>
                <li class="float-right"><a class="underline_effect">
                    <RouterLink to="/admin">Админ панель</RouterLink>
                </a></li>
                <li class="float-right"><a class="underline_effect">
                    <RouterLink to="/report">Отчеты</RouterLink>
                </a></li>
                
            </ul>
        </div>
    </header>
</template>

<script setup>

</script>

<style scoped>
header {
    width: auto;
    height: 100px;
    background-color: rgb(24, 24, 27);
    vertical-align: middle;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-bottom: 20px;
}

.header_container {
    width: 1200px;
    height: 100px;
    background-color: rgb(24, 24, 27);
    vertical-align: middle;
    display: flex;
    align-items: center;
}

.logo {
    height: 70px;
    display: inline-block;
    margin-right: 20px;
}

ul {
    display: inline;
}

li {
    display: inline;
    color: white;
    margin-right: 20px;
}

.underline_effect {
    color: white;
    /* Цвет обычной ссылки */
    position: relative;
    cursor: pointer;
    text-decoration: none;
    /* Убираем подчеркивание */
}

.underline_effect:after {
    content: "";
    display: block;
    position: absolute;
    right: 0;
    bottom: -3px;
    width: 0;
    height: 2px;
    /* Высота линии */
    background-color: white;
    /* Цвет подчеркивания при исчезании линии*/
    transition: width 0.2s;
    /* Время эффекта */
}

.underline_effect:hover:after {
    content: "";
    width: 100%;
    display: block;
    position: absolute;
    left: 0;
    bottom: -3px;
    height: 2px;
    /* Высота линии */
    background-color: white;
    /* Цвет подчеркивания при появлении линии*/
    transition: width 0.5s;
    /* Время эффекта */
}

.underline_effect:focus {
    animation: pulse 0.2s;
}

@keyframes pulse {
    from {
        color: white;
    }

    to {
        color: black;
    }
}



.h_schedule {
    color: white;
}
</style>