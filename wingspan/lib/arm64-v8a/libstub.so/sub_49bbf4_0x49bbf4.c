// 函数: sub_49bbf4
// 地址: 0x49bbf4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
char* x9 = *(arg1 + 0x10)

if (*(arg1 + 0x18) - x9 + 1 u>= 0x21)
    int128_t var_60
    int128_t* x8_4 = &var_60
    int128_t var_70
    int64_t x9_1
    char x11_4
    
    if (&x9[0x20] u<= &var_70 || x9 u>= &var_60)
        arg3.b = *x9
        arg4.b = x9[1]
        arg3:1.b = x9[2]
        arg4:1.b = x9[3]
        arg3:2.b = x9[4]
        arg4:2.b = x9[5]
        arg3:3.b = x9[6]
        arg4:3.b = x9[7]
        arg3:4.b = x9[8]
        arg4:4.b = x9[9]
        arg3:5.b = x9[0xa]
        arg4:5.b = x9[0xb]
        arg3:6.b = x9[0xc]
        arg4:6.b = x9[0xd]
        arg3:7.b = x9[0xe]
        arg4:7.b = x9[0xf]
        arg3:8.b = x9[0x10]
        arg4:8.b = x9[0x11]
        arg3:9.b = x9[0x12]
        arg4:9.b = x9[0x13]
        arg3:0xa.b = x9[0x14]
        arg4:0xa.b = x9[0x15]
        arg3:0xb.b = x9[0x16]
        arg4:0xb.b = x9[0x17]
        arg3:0xc.b = x9[0x18]
        arg4:0xc.b = x9[0x19]
        arg3:0xd.b = x9[0x1a]
        arg4:0xd.b = x9[0x1b]
        arg3:0xe.b = x9[0x1c]
        arg4:0xe.b = x9[0x1d]
        arg3:0xf.b = x9[0x1e]
        arg4:0xf.b = x9[0x1f]
        int128_t v2 = not.o(zx.o(0x2f))
        x9_1 = 0xf
        arg6.w = zx.w(arg3:8.b)
        arg6:2.w = zx.w(arg3:9.b)
        arg6:4.w = zx.w(arg3:0xa.b)
        arg6:6.w = zx.w(arg3:0xb.b)
        arg6:8.w = zx.w(arg3:0xc.b)
        arg6:0xa.w = zx.w(arg3:0xd.b)
        arg6:0xc.w = zx.w(arg3:0xe.b)
        arg6:0xe.w = zx.w(arg3:0xf.b)
        arg7.w = zx.w(arg3.b)
        arg7:2.w = zx.w(arg3:1.b)
        arg7:4.w = zx.w(arg3:2.b)
        arg7:6.w = zx.w(arg3:3.b)
        arg7:8.w = zx.w(arg3:4.b)
        arg7:0xa.w = zx.w(arg3:5.b)
        arg7:0xc.w = zx.w(arg3:6.b)
        arg7:0xe.w = zx.w(arg3:7.b)
        arg8.w = zx.w(arg4:8.b)
        arg8:2.w = zx.w(arg4:9.b)
        arg8:4.w = zx.w(arg4:0xa.b)
        arg8:6.w = zx.w(arg4:0xb.b)
        arg8:8.w = zx.w(arg4:0xc.b)
        arg8:0xa.w = zx.w(arg4:0xd.b)
        arg8:0xc.w = zx.w(arg4:0xe.b)
        arg8:0xe.w = zx.w(arg4:0xf.b)
        arg9.w = zx.w(arg4.b)
        arg9:2.w = zx.w(arg4:1.b)
        arg9:4.w = zx.w(arg4:2.b)
        arg9:6.w = zx.w(arg4:3.b)
        arg9:8.w = zx.w(arg4:4.b)
        arg9:0xa.w = zx.w(arg4:5.b)
        arg9:0xc.w = zx.w(arg4:6.b)
        arg9:0xe.w = zx.w(arg4:7.b)
        uint128_t v7 = vaddw_u16(v2, arg7)
        uint128_t v4 = vaddw_high_u16(v2, arg7)
        uint128_t v16_1 = vaddw_u16(v2, arg6)
        uint128_t v3 = vaddw_high_u16(v2, arg6)
        uint128_t v17_1 = vaddw_u16(v2, arg9)
        uint128_t v6 = vaddw_high_u16(v2, arg9)
        uint128_t v18_1 = vaddw_u16(v2, arg8)
        uint128_t v2_1 = vaddw_high_u16(v2, arg8)
        arg8.d = 9
        arg8:4.d = 9
        arg8:8.d = 9
        arg8:0xc.d = 9
        uint128_t v16_2 = vcgtq_u32(v16_1, arg8)
        uint128_t v3_1 = vcgtq_u32(v3, arg8)
        arg10 = vcgtq_u32(v7, arg8)
        vmovn_s32(v16_2)
        uint128_t v4_1 = vcgtq_u32(v4, arg8)
        uint128_t v16_4 = vmovn_high_s32(v3_1)
        vmovn_s32(arg10)
        uint128_t v3_3 = vmovn_high_s32(v4_1)
        uint128_t v2_2 = vcgtq_u32(v2_1, arg8)
        uint128_t v18_2 = vcgtq_u32(v18_1, arg8)
        arg9 = vcgtq_u32(v6, arg8)
        uint128_t v5 = vcgtq_u32(v17_1, arg8)
        vmovn_s16(v3_3)
        uint128_t v3_5 = vmovn_high_s16(v16_4)
        vmovn_s32(v18_2)
        vmovn_s32(v5)
        v4_1.b = 9
        v4_1:1.b = 9
        v4_1:2.b = 9
        v4_1:3.b = 9
        v4_1:4.b = 9
        v4_1:5.b = 9
        v4_1:6.b = 9
        v4_1:7.b = 9
        v4_1:8.b = 9
        v4_1:9.b = 9
        v4_1:0xa.b = 9
        v4_1:0xb.b = 9
        v4_1:0xc.b = 9
        v4_1:0xd.b = 9
        v4_1:0xe.b = 9
        v4_1:0xf.b = 9
        uint128_t v16_6 = vmovn_high_s32(v2_2)
        arg8 = vmovn_high_s32(arg9)
        vmovn_s16(arg8)
        arg10.b = 0xd0
        arg10:1.b = 0xd0
        arg10:2.b = 0xd0
        arg10:3.b = 0xd0
        arg10:4.b = 0xd0
        arg10:5.b = 0xd0
        arg10:6.b = 0xd0
        arg10:7.b = 0xd0
        arg10:8.b = 0xd0
        arg10:9.b = 0xd0
        arg10:0xa.b = 0xd0
        arg10:0xb.b = 0xd0
        arg10:0xc.b = 0xd0
        arg10:0xd.b = 0xd0
        arg10:0xe.b = 0xd0
        arg10:0xf.b = 0xd0
        v2_2.b = 0xa9
        v2_2:1.b = 0xa9
        v2_2:2.b = 0xa9
        v2_2:3.b = 0xa9
        v2_2:4.b = 0xa9
        v2_2:5.b = 0xa9
        v2_2:6.b = 0xa9
        v2_2:7.b = 0xa9
        v2_2:8.b = 0xa9
        v2_2:9.b = 0xa9
        v2_2:0xa.b = 0xa9
        v2_2:0xb.b = 0xa9
        v2_2:0xc.b = 0xa9
        v2_2:0xd.b = 0xa9
        v2_2:0xe.b = 0xa9
        v2_2:0xf.b = 0xa9
        arg7 = vmovn_high_s16(v16_6)
        arg5 = vbslq_s8(arg7, v2_2, arg10)
        arg6.b = ((v3_5 & v4_1) + arg3).b << 4
        arg6:1.b <<= 4
        arg6:2.b <<= 4
        arg6:3.b <<= 4
        arg6:4.b <<= 4
        arg6:5.b <<= 4
        arg6:6.b <<= 4
        arg6:7.b <<= 4
        arg6:8.b <<= 4
        arg6:9.b <<= 4
        arg6:0xa.b <<= 4
        arg6:0xb.b <<= 4
        arg6:0xc.b <<= 4
        arg6:0xd.b <<= 4
        arg6:0xe.b <<= 4
        arg6:0xf.b <<= 4
        arg3 = arg5 + arg4 + arg6
        var_70 = arg3
        x11_4 = arg3:0xf.b
    else
        int64_t i = 0
        int64_t x10_2 = 0
        
        do
            char* x11_1 = &x9[i]
            uint32_t x16_1 = zx.d(*x11_1)
            uint32_t x11_2 = zx.d(x11_1[1])
            i += 2
            int32_t x17_2
            
            if (x16_1 - 0x30 u> 9)
                x17_2 = 9
            else
                x17_2 = 0
            
            char x17_3
            
            if (x11_2 - 0x30 u> 9)
                x17_3 = -0x57
            else
                x17_3 = -0x30
            
            x11_4 = x17_3 + x11_2.b + ((x17_2 + x16_1) << 4).b
            *(&var_70 + x10_2) = x11_4
            x10_2 += 1
        while (i != 0x20)
        
        x8_4 = &var_70 + x10_2
        x9_1 = x10_2 - 1
    
    if (x8_4 != &var_70 && &var_70 + x9_1 u> &var_70)
        var_70.b = x11_4
        *(&var_70 + x9_1) = var_70.b
        
        if (x9_1 u>= 3)
            void* x8_8 = x9_1 + &var_70 - 1
            void* x9_2 = &var_70 | 2
            bool cond:4_1
            
            do
                char x11_5 = *(x9_2 - 1)
                *(x9_2 - 1) = *x8_8
                *x8_8 = x11_5
                x8_8 -= 1
                cond:4_1 = x9_2 u< x8_8
                x9_2 += 1
            while (cond:4_1)
    
    arg3 = var_70
    arg4.q = 0
    arg4:8.q = 0
    __builtin_memset(&var_60, 0, 0x28)
    int64_t entry_x4
    arg1 = sub_49b8a4(&var_60, 0x28, 0x28, "%LaL", entry_x4, arg3, arg4, arg5, arg6, arg7, arg8, 
        arg9, arg10)
    
    if (arg1.d != 0)
        int64_t x8_9 = arg2[1]
        int64_t x10_4 = arg2[2]
        int64_t x20_1 = sx.q(arg1.d)
        int64_t bytes_2 = x8_9 + x20_1
        int64_t x0_2
        
        if (bytes_2 u>= x10_4)
            int64_t oldmem = *arg2
            int64_t bytes_1 = x10_4 << 1
            int64_t bytes
            
            bytes = bytes_1 u< bytes_2 ? bytes_2 : bytes_1
            
            arg2[2] = bytes
            x0_2 = realloc(oldmem, bytes)
            *arg2 = x0_2
            
            if (x0_2 == 0)
                sub_491944()
                noreturn
            
            x8_9 = arg2[1]
        else
            x0_2 = *arg2
        
        memmove(x0_2 + x8_9, &var_60, x20_1)
        arg2[1] += x20_1

if (*(x21 + 0x28) == x8)
    return 

__stack_chk_fail()
noreturn
