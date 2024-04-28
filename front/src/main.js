import './assets/main.css';

import { createApp } from 'vue';
import router from './router/router.js';
import App from './App.vue';
import './config.js';

createApp(App).use(router).mount('#app');
