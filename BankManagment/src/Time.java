class Time
{
	private int hr,min;
	public Time(int h,int m)
	{
		hr=h;min=m;
	}
	public Time(Time t)
	{
		hr=t.hr;
		min=t.min;
	}
	public int timeDiff(Time t)
	{
		if(hr<t.hr)
		{
			return t.hr-hr;
		}
		else
		{
			if (t.hr==hr)
				return 1;
		}
		return 0;
	}
}
