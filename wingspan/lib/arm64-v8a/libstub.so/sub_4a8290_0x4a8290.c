// 函数: sub_4a8290
// 地址: 0x4a8290
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void var_3c0
memcpy(&var_3c0, arg1, 0x3c0)
int64_t var_2c8
int64_t var_80
char var_49
void var_3d0

if (((var_80 & 0x40000000) == 0 || zx.d(var_49) == 0) && var_2c8 == 0)
    sub_4a70dc(&var_3c0, *(arg1 + 0x310), &var_3d0)

if ((*(arg1 + 0x340) & 0x40000000) != 0)
    *(arg1 + 0x377) = 0

int32_t x0_6 = arg2[0xc8].d
*(arg1 + 0xf8) = 0
int64_t var_3c8
void* x23_1

if (x0_6 == 1)
    x23_1 = sub_4a7118(&var_3c0, arg2[0xc6].d) + arg2[0xc5]
label_4a835c:
    *(arg1 + 0x310) = x23_1
    int64_t* x26_1 = arg2
    void* x22_1 = arg1 + 0x358
    int64_t x20_1 = 0
    
    while (true)
        int32_t x0_13 = x26_1[1].d - 1
        
        if (x0_13 u<= 4)
            int64_t* x0_17
            
            switch (x0_13)
                case 0
                    x0_17 = x23_1 + *x26_1
                label_4a8408:
                    
                    if ((*(arg1 + 0x340) & 0x40000000) != 0)
                        *x22_1 = 0
                case 1
                    int32_t x1_6 = (*x26_1).d
                    
                    if (zx.d(*(&var_3c0 + sx.q(x1_6) + 0x358)) == 0)
                        x0_17 = *(&var_3c0 + (sx.q(x1_6) << 3))
                        goto label_4a8408
                    
                    x0_17 = sub_4a7118(&var_3c0, x1_6)
                    goto label_4a83d0
                case 2
                    char* x0_22 = sub_4a6e70(*x26_1, &var_3c8)
                    x0_17 = sub_4a7cdc(x0_22, &x0_22[var_3c8], &var_3c0, x23_1)
                    goto label_4a8408
                case 3
                    x0_17 = x23_1 + *x26_1
                label_4a83d0:
                    
                    if (zx.d((&data_4b0fd0)[x20_1]) u> 8)
                        break
                    
                    *x22_1 = 1
                case 4
                    char* x0_25 = sub_4a6e70(*x26_1, &var_3c8)
                    x0_17 = sub_4a7cdc(x0_25, &x0_25[var_3c8], &var_3c0, x23_1)
                    goto label_4a83d0
            
            *(arg1 + (x20_1 << 3)) = x0_17
        
        x20_1 += 1
        x26_1 = &x26_1[2]
        x22_1 += 1
        
        if (x20_1 == 0x62)
            int64_t x0_26 = *(arg1 + 0x340)
            int64_t result
            
            if (zx.d(*(arg2 + 0x673)) == 0)
                result = x0_26 & 0x7fffffffffffffff
            else
                result = x0_26 | 0x8000000000000000
            
            *(arg1 + 0x340) = result
            return result
else if (x0_6 == 2)
    char* x0_8 = sub_4a6e70(arg2[0xc7], &var_3c8)
    x23_1 = sub_4a7cdc(x0_8, &x0_8[var_3c8], &var_3c0, 0)
    goto label_4a835c
abort()
noreturn
