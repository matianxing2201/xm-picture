import axios from "axios";
import { message } from "ant-design-vue";

const request = axios.create({
  baseURL: import.meta.env.VITE_API_URL as string,
  timeout: import.meta.env.VITE_TIME_OUT,
  withCredentials: true,
});

// 全局请求拦截器
request.interceptors.request.use(
  function (config) {
    // Do something before request is sent
    return config;
  },
  function (error) {
    // Do something with request error
    return Promise.reject(error);
  }
);

// 全局响应拦截器
request.interceptors.response.use(
  function (response) {
    const { data } = response;
    // 未登录
    if (data.code === 40100) {
      message.warning("请先登录");
      window.location.href = `/user/login?redirect=${window.location.href}`;
    }
    return response;
  },
  function (error) {
    // Any status codes that falls outside the range of 2xx cause this function to trigger
    // Do something with response error
    return Promise.reject(error);
  }
);

export default request;
