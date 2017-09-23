package cn.imaq.java9demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessAPIDemo {
    public static void main(String[] args) {
        // 新特性：ProcessHandle 接口
        // 获取操作系统中正在运行的所有进程
        System.out.println("All processes:");
        ProcessHandle.allProcesses().forEach(ph -> {
            if (ph.info().command().isPresent()) {
                System.out.println("PID=" + ph.pid() + " " + ph.info().command().get());
                // 结束命令中含有 jshell 的进程（演示用）
                if (ph.info().command().get().contains("jshell")) {
                    ph.destroy();
                }
            }
        });

        // 新特性：Pipeline 支持
        // 输出所有正在监听的 TCP 端口 (Windows 环境)
        // 相当于执行 "netstat -a -n -v |findstr LISTENING"
        System.out.println("\nAll listening sockets:");
        List<ProcessBuilder> builderList = new ArrayList<>() {{
            add(new ProcessBuilder("netstat", "-a", "-n", "-v"));
            add(new ProcessBuilder("findstr", "LISTENING"));
        }};
        try {
            List<Process> processList = ProcessBuilder.startPipeline(builderList);
            Process lastProcess = processList.get(processList.size() - 1);
            BufferedReader reader = new BufferedReader(new InputStreamReader(lastProcess.getInputStream()));
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
