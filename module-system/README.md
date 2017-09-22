# Module System (Jigsaw) Demo

## 模块
- [helloservice](helloservice/) - 提供输出 "Hello, xxx!" 信息的接口
- [hellomod](hellomod/) - 接口调用方

## 一些脚本 (Windows 环境)
- [build_module.bat](build_module.bat) - 编译两个模块
- [run_module.bat](run_module.bat) - 运行 hellomod 模块中的 main 方法
- [package_module.bat](package_module.bat) - 将两个模块同时打包为 jar / jmod 格式
- [link_module.bat](link_module.bat) - 链接所有模块，在 build/helloapp 下生成运行时镜像，并执行镜像输出镜像中的模块列表
