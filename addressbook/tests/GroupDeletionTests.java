package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Testik1", null, null));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().submitGroupCreation();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
    app.getGroupHelper().gotoHomePage();
  }
}
