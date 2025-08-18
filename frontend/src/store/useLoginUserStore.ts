import { User } from "@/api/interface/index";

export const useLoginUserStore = defineStore("loginUser", () => {
  const loginUser = ref<User.LoginUserVo>({
    userName: "",
  });

  return {
    loginUser,
  };
});
