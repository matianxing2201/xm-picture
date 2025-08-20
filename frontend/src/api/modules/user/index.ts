import request from "../../index";
import { IUser } from "../../interface";

export const userLogin = (
  params: IUser.LoginRequest
): Promise<IUser.LoginUserVo> => {
  return request.post("/user/login", params);
};

export const userRegister = (params: IUser.RegisterRequest) => {
  return request.post("/user/register", params);
};

export const userLogout = () => {
  return request.post("/user/logout");
};
