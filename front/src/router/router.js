import { createMemoryHistory, createRouter,createWebHistory } from 'vue-router';

import ShowList from '@/views/ShowList.vue';
import FilmList from '@/views/FilmList.vue';
import AdminPanel from '@/views/AdminPanel.vue';
import Login from '@/views/Login.vue';
import ReportPanel from '@/views/ReportPanel.vue';
import FilmReport from '@/views/reports/FilmReport.vue';
import ShowReport from '@/views/reports/ShowReport.vue';
import HallCapacityReport from '@/views/reports/HallCapacityReport.vue';
import Film from '@/views/Film.vue';

const routes = [
    { path: '/shows/:date', component: ShowList },
    { path: '/', component: ShowList },
    { path: '/films', component: FilmList },
    { path: '/films/:id', component: Film },
    { path: '/admin', component: AdminPanel },
    { path: '/login', component: Login },
    { path: '/report', component: ReportPanel },

    { path: '/report/film', component: FilmReport },
    { path: '/report/show', component: ShowReport },
    { path: '/report/capacity', component: HallCapacityReport }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
