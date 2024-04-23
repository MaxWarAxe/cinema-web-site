import { createMemoryHistory, createRouter } from 'vue-router';

import FilmList from '@/views/FilmList.vue';
import Contacts from '@/views/Contacts.vue';

const routes = [
    { path: '/films', component: FilmList },
    { path: '/', component: FilmList },
    { path: '/contacts', component: Contacts }
];

const router = createRouter({
    history: createMemoryHistory(),
    routes
});

export default router;
