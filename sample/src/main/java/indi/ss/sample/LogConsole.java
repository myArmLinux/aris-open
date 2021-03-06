package indi.ss.sample;

import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ss.aris.open.console.CharacterInputCallback;
import com.ss.aris.open.console.InputCallback;
import com.ss.aris.open.console.KeyDownCallback;
import com.ss.aris.open.console.OnEnterListener;
import com.ss.aris.open.console.SingleLineInputCallback;
import com.ss.aris.open.console.impl.ResultCallback;
import com.ss.aris.open.console.text.OnTextClickListener;
import com.ss.aris.open.pipes.BasePipe;
import com.ss.aris.open.pipes.entity.Instruction;
import com.ss.aris.open.pipes.entity.Pipe;
import com.ss.aris.open.console.impl.DeviceConsole;
import com.ss.aris.open.console.impl.PermissionCallback;
import com.ss.aris.open.console.text.OnTypingFinishCallback;
import com.ss.aris.open.console.text.TypingOption;
import java.util.Collection;

public class LogConsole implements DeviceConsole {

    private void log(String msg){
        Log.d("LogConsole", msg);
    }

    @Override
    public void input(String string) {
        log("input: " + string);
    }

    @Override
    public void runScript(String script, OnEnterListener onEnterListener) {
        log("runScript: " + script);
    }

    @Override
    public void shareIntentByScript(String script) {

    }

    @Override
    public void showInputMethod() {

    }

    @Override
    public void input(String string, OnTypingFinishCallback callback, TypingOption option, OnTextClickListener listener) {
        log("input:" + string);
    }

    @Override
    public void display(String string) {
        log("display: " + string);
    }

    @Override
    public void display(String string, Pipe tag) {
        log("display with tag: " + string);
    }

    @Override
    public void blockInput() {
        log("blockInput");
    }

    @Override
    public void releaseInput() {
        log("releaseInput");
    }

    @Override
    public void clear() {
        log("clear");
    }

    @Override
    public void intercept() {
        log("intercept");
    }

    @Override
    public String getLastInput(int index) {
        return null;
    }

    @Override
    public void waitForSingleLineInput(SingleLineInputCallback inputCallback, boolean requireClipboard) {

    }

    @Override
    public void waitForPasswordInput(SingleLineInputCallback inputCallback, boolean requireClipboard) {

    }

    @Override
    public void waitForCharacterInput(CharacterInputCallback inputCallback) {
        log("wait for character");
        inputCallback.onCharacterInput("f");
    }

    @Override
    public void blindMode() {
        log("blind");
    }

    @Override
    public void quitBlind() {
        log("qui blind");
    }

    @Override
    public void addInputCallback(InputCallback inputCallback) {
        log("add input callback");
        inputCallback.onInput("input");
    }

    @Override
    public void removeInputCallback(InputCallback inputCallback) {
        log("remove input callback");
    }

    @Override
    public void setIndicator(String indicator) {
        log("set indicator");
    }

    @Override
    public void setInputType(int inputType) {
        log("set input type");
    }

    @Override
    public int getInputType() {
        return 0;
    }

    @Override
    public void reshowTerminal() {

    }

    @Override
    public void replaceCurrentView(View view) {

    }

    @Override
    public void notify(Pipe pipe) {
        log("notify pipe");
    }

    @Override
    public void notifyByName(String name) {
        log("notify pipe by name: " + name);
    }

    @Override
    public BasePipe.OutputCallback getOutputCallback() {
        return new BasePipe.OutputCallback() {
            @Override
            public void onOutput(String output) {
                display(output);
            }
        };
    }

    @Override
    public Typeface getTypeface() {
        return null;
    }

    @Override
    public TextView getDisplayTextView() {
        return null;
    }

    @Override
    public void onSystemReady() {
        log("system ready");
    }

    @Override
    public void displayResult(Collection<Pipe> pipe, Instruction instruction, int selection) {
        StringBuilder sb = new StringBuilder();
        for (Pipe p : pipe){
            sb.append(p.getDisplayName())
                    .append(", ")
                    .append(p.getExecutable())
                    .append("\n");
        }

        log(sb.toString());
    }

    @Override
    public void onEnter(Pipe pipe) {
        log("enter: " + pipe.getDisplayName());
    }

    @Override
    public void onSelected(Pipe pipe) {
        log("select: " + pipe.getDisplayName());
    }

    @Override
    public void onNothing() {
        log("nothing");
    }

    @Override
    public void requestPermission(String[] permissions, PermissionCallback callback) {

    }

    @Override
    public void requestResult(Intent intent, ResultCallback callback) {

    }

}
