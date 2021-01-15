import javax.swing.JFrame;

public class Saving  extends Accounts
{
	int saving;
	Saving()
	{
		saving=0;
	}
	Saving(int s)
	{
		saving=s;
	}
	void setSaving(int s)
	{
		saving=s;
	}
	int getSaving()
	{
		return saving;
	}
}
