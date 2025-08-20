import { createApp } from "vue";
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";
import router from "./router";
import App from "./App.vue";
import "@/assets/style/index.css";

const app = createApp(App);
app.use(createPinia().use(piniaPluginPersistedstate));
app.use(router);
app.mount("#app");
