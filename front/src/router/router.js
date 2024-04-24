import { createMemoryHistory, createRouter } from 'vue-router';

import FilmList from '@/views/FilmList.vue';
import Contacts from '@/views/Contacts.vue';
import AdminPanel from '@/views/AdminPanel.vue';
import Login from '@/views/Login.vue';
import ReportPanel from '@/views/ReportPanel.vue';

const routes = [
    { path: '/films', component: FilmList },
    { path: '/', component: FilmList },
    { path: '/contacts', component: Contacts },
    { path: '/admin', component: AdminPanel },
    { path: '/login', component: Login },
    { path: '/report', component: ReportPanel },
];

const router = createRouter({
    history: createMemoryHistory(),
    routes
});

export default router;
