import request from "../index";

export const test = () => {
  return request.get("/health");
};
