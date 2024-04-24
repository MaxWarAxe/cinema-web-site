import { createMemoryHistory, createRouter } from 'vue-router';

import FilmList from '@/views/FilmList.vue';
import Contacts from '@/views/Contacts.vue';
import AdminPanel from '@/views/AdminPanel.vue';
import Login from '@/views/Login.vue';

const routes = [
    { path: '/films', component: FilmList },
    { path: '/', component: FilmList },
    { path: '/contacts', component: Contacts },
    { path: '/admin', component: AdminPanel },
    { path: '/login', component: Login },
];

const router = createRouter({
    history: createMemoryHistory(),
    routes
});

export default router;
