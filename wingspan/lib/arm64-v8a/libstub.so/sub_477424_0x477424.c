// 函数: sub_477424
// 地址: 0x477424
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t v8
int64_t var_40 = v8
uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_90
__builtin_memset(&var_90, 0, 0x30)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t var_80
int64_t var_68
int32_t x20_1

if ((sub_45be5c(arg1, &var_68, &var_80, 1, "androidx/loader/app/services/", &data_40e8db, 
        "(Ljava/lang/Object;)Landroid/util/DisplayMetrics;") & 1) != 0)
    x20_1 = 0
else
    int64_t var_60 = x0_2
    int64_t x0_6 = (*(*arg1 + 0x3a0))(arg1, var_68, var_80, &var_60)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        x20_1 = 0
    else
        if (x0_2 != 0)
            (*(*arg1 + 0xb8))(arg1, x0_2)
        
        int64_t var_88
        int64_t x2_3 = var_88
        
        if (x2_3 != 0)
            goto label_477550
        
        int64_t var_70
        
        if ((sub_45be5c(arg1, &var_70, &var_88, 1, "androidx/loader/app/services/", &data_40cace, 
                "(IFLjava/lang/Object;)F") & 1) != 0)
            x20_1 = 0
        else
            x2_3 = var_88
        label_477550:
            var_60.d = 1
            float var_58_1 = float.s(arg4)
            int64_t var_50_1 = x0_6
            int64_t v0_2 = (*(*arg1 + 0x448))(arg1, var_70, x2_3, &var_60)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x20_1 = 0
            else
                int64_t x2_4 = var_90
                
                if (x2_4 != 0)
                    goto label_4775cc
                
                int64_t var_78
                
                if ((sub_45be5c(arg1, &var_78, &var_90, 1, "androidx/loader/app/services/", 
                        &data_40e1a0, "(F)I") & 1) != 0)
                    x20_1 = 0
                else
                    x2_4 = var_90
                label_4775cc:
                    var_60.d = v0_2.d
                    x20_1 = (*(*arg1 + 0x418))(arg1, var_78, x2_4, &var_60)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        x20_1 = 0

if (*(x23 + 0x28) == x8)
    return zx.q(x20_1)

__stack_chk_fail()
noreturn
