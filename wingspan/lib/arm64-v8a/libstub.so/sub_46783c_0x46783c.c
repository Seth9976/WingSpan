// 函数: sub_46783c
// 地址: 0x46783c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_98
__builtin_memset(&var_98, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg4)
int128_t result
result.d = 0f
int64_t var_90
int64_t var_78
int32_t var_70

if ((sub_45be5c(arg1, &var_78, &var_90, 1, "androidx/loader/app/services/", 0x451d55, 0x452601) & 1)
        == 0 && (*(*arg1 + 0x418))(arg1, var_78, var_90, &var_70) s>= 1
        && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
    int64_t var_80
    int64_t x2_2 = var_80
    
    if (x2_2 != 0)
        goto label_467968
    
    if ((sub_45bc9c(arg1, &var_80, "android/util/DisplayMetrics") & 1) == 0)
        x2_2 = var_80
    label_467968:
        
        if ((sub_45bc08(arg1, x0, x2_2, "android/util/DisplayMetrics") & 1) == 0
                && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
            int64_t x2_3 = var_98
            
            if (x2_3 != 0)
                goto label_4679c4
            
            int64_t var_88
            
            if ((sub_45be5c(arg1, &var_88, &var_98, 1, "android/util/TypedValue", "applyDimension", 
                    "(IFLandroid/util/DisplayMetrics;)F") & 1) == 0)
                x2_3 = var_98
            label_4679c4:
                var_70 = arg3
                int32_t v0
                int32_t var_68_1 = v0
                int64_t var_60_1 = x0
                int128_t result_1 = (*(*arg1 + 0x448))(arg1, var_88, x2_3, &var_70)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                    result = result_1

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
