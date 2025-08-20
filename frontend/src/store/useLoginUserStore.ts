import { IUser } from "@/api/interface/index";

export const useLoginUserStore = defineStore(
  "loginUser",
  () => {
    const loginUser = ref<IUser.LoginUserVo>({});

    function setLoginUser(user: IUser.LoginUserVo) {
      loginUser.value = user;
    }

    return {
      loginUser,
      setLoginUser,
    };
  },
  {
    persist: {
      key: "loginUser",
      storage: localStorage,
    },
  }
);
