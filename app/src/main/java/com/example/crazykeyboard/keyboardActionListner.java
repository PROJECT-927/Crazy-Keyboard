package com.example.crazykeyboard;


import android.inputmethodservice.KeyboardView;

public class MyKeyboardActionListener implements KeyboardView.OnKeyboardActionListener {
    private InputMethodService inputMethodService;

    public MyKeyboardActionListener(InputMethodService ims) {
        this.inputMethodService = ims;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = inputMethodService.getCurrentInputConnection();
        if (ic != null) {
            if (primaryCode == Keyboard.KEYCODE_DELETE) {
                ic.deleteSurroundingText(1, 0);
            } else {
                char code = (char) primaryCode;
                ic.commitText(String.valueOf(code), 1);
            }
        }
    }

    // Implement other methods (onPress, onRelease, etc.) as needed
    @Override public void onPress(int primaryCode) {}
    @Override public void onRelease(int primaryCode) {}
    @Override public void onText(CharSequence text) {}
    @Override public void swipeLeft() {}
    @Override public void swipeRight() {}
    @Override public void swipeDown() {}
    @Override public void swipeUp() {}
}

