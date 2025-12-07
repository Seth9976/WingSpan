// 函数: sub_4914a0
// 地址: 0x4914a0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

size_t bytes

bytes = arg1 != 0 ? arg1 : 1

while (true)
    int64_t result = malloc(bytes)
    
    if (result != 0)
        return result
    
    int64_t x0_1 = sub_4919ec()
    
    if (x0_1 == 0)
        break
    
    x0_1()

void* x0_2 = sub_49153c(8)
sub_4a6e48(x0_2)
sub_491588(x0_2, &_typeinfo_for_std::bad_alloc, sub_4a6e34)
noreturn
