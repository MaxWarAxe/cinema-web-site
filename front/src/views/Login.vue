<template>
    <div class="block">
        <p class="m-10 text-white text-center">Вход</p>
        <InputCustom type="text" defaultText="Логин" class="mb-10"/>
        <InputCustom type="password" defaultText="Пароль" class="mb-10"/>
        <ButtonCustom class="w-32 block ml-auto mr-auto" text="Войти"/>
    </div>
</template>

<script setup>
    import InputCustom from '@/components/InputCustom.vue';
    import ButtonCustom from '@/components/ButtonCustom.vue';
</script>

<style scoped>
</style>