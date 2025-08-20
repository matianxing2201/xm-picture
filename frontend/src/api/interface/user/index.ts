export interface LoginUserVo {
  createTime?: string;
  editTime?: string;
  id?: number;
  updateTime?: string;
  userAccount?: string;
  userAvatar?: string;
  userName?: string;
  userProfile?: string;
  userRole?: string;
}

export interface LoginRequest {
  userAccount: string;
  userPassword: string;
}

export interface RegisterRequest {
  checkPassword: string;
  userAccount: string;
  userPassword: string;
}
