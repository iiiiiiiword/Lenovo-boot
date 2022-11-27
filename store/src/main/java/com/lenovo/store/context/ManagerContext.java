package com.lenovo.store.context;

import com.lenovo.store.bean.dto.JwtUserDTO;

public class ManagerContext {
    private static ThreadLocal<JwtUserDTO> threadLocal = new ThreadLocal<>();
    public static void set(JwtUserDTO dto) {
        threadLocal.set(dto);
    }
    public static JwtUserDTO get() {
        return threadLocal.get();
    }
    public static void remove() {
        threadLocal.remove();
    }
}
