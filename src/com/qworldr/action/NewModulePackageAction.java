package com.qworldr.action;

import com.intellij.ide.IdeView;
import com.intellij.ide.actions.CreateInDirectoryActionBase;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.qworldr.ui.NewModulePackageDialog;

import java.util.List;

/**
 * @Author wujiazhen
 * @Date 2018/12/5
 */
public class NewModulePackageAction extends CreateInDirectoryActionBase {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        IdeView view = (IdeView) e.getData(LangDataKeys.IDE_VIEW);
        if (view == null) {
            return;
        }
        Project project = e.getProject();
        PsiDirectory dir = view.getOrChooseDirectory();
        if (dir == null) {
            return;
        }
        NewModulePackageDialog newModulePackageDialog = new NewModulePackageDialog(project, dir);
        newModulePackageDialog.show();
        List<PsiElement> psiElementList = newModulePackageDialog.getPsiElementList();
        psiElementList.forEach(psiElement -> {
            view.selectElement(psiElement);
        });
    }


}
