// 函数: sub_4a8868
// 地址: 0x4a8868
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void var_e00
void arg_0
int64_t lr
sub_4a849c(&var_e00, &arg_0, lr)
void var_a40
memcpy(&var_a40, &var_e00, 0x3c0)

while (true)
    void var_680
    int32_t x0_3 = sub_4a78b8(&var_a40, &var_680)
    
    if (x0_3 == 5 || x0_3 != 0)
        return arg1
    
    int64_t var_30
    
    if (var_30 != 0)
        int32_t x0_6 = var_30(1, 1, *arg1, arg1, &var_a40)
        
        if (x0_6 == 6)
            arg1[2] = 0
            int64_t var_700
            arg1[3] = sub_4a727c(&var_a40) - (var_700 u>> 0x3f)
            memcpy(&var_a40, &var_e00, 0x3c0)
            
            if (sub_4a85c4(arg1, &var_a40) == 7)
                sub_4a7170(&var_e00, &var_a40)
            
            return arg1
        
        if (x0_6 != 8)
            return arg1
    
    sub_4a8578(&var_a40, &var_680)
