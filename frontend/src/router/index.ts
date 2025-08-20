import { useLoginUserStore } from "@/store/useLoginUserStore";
import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "主页",
      component: () => import("@/views/HomePage.vue"),
    },
    {
      path: "/user/login",
      name: "login",
      component: () => import("@/views/user/Login.vue"),
    },
    {
      path: "/user/register",
      name: "register",
      component: () => import("@/views/user/Register.vue"),
    },
    {
      path: "/user/management",
      name: "management",
      component: () => import("@/views/user/UserManagement.vue"),
    },
  ],
});

router.beforeEach((to, from, next) => {
  const loginUser = useLoginUserStore();

  // 动态设置标题
  const title = import.meta.env.VITE_GLOB_APP_TITLE;
  document.title = to.meta.title ? `${to.meta.title} - ${title}` : title;

  // if (to.path === "/user/login" || to.path === "/user/register") {
  //   if (loginUser.loginUser.id) return next(from.fullPath);
  //   return next();
  // }
  // // 登录校验
  // if (!loginUser.loginUser.id) {
  //   const white = ["user/login", "user/register"];
  //   const isWhite = white.includes(to.path);
  //   return next({
  //     path: isWhite ? to.path : "/user/login",
  //     replace: true,
  //   });
  // }
  next();
});

export default router;
